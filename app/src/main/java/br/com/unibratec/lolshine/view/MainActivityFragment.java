package br.com.unibratec.lolshine.view;


import android.app.SearchManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.unibratec.lolshine.R;
import br.com.unibratec.lolshine.model.Game;
import br.com.unibratec.lolshine.model.OnItemSelectedCallback;
import br.com.unibratec.lolshine.model.PlayerHistory;
import br.com.unibratec.lolshine.model.Utility;


public class MainActivityFragment extends Fragment {

    private PlayerHistory mPlayerHistory;
    private ListView mListView;
    private LoLShineTask task;
    private SearchManager searchManager;
    private SearchView searchView;
    private long mSummonerId;
    private String mSummonerName;
    private int mSummonerLevel;


    public MainActivityFragment() {
    }

    // Reter a instancia dos atributos no create, habilitar op��o de menu
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        // Get the SearchView and set the searchable configuration
        searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search)
                .getActionView();
        searchPlayer();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        mListView = (ListView) view.findViewById(R.id.listView_matches);
        // Passa os matches do mPlayHistory para a outra activity
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Game game = mPlayerHistory.getGames().get(i);
                game.setSummonerId(mSummonerId);
                game.setSummonerName(mSummonerName);
                game.setSummonerLevel(mSummonerLevel);
                if (getActivity() instanceof OnItemSelectedCallback) {
                    ((OnItemSelectedCallback) getActivity()).onItemSelected(game);
                }
            }
        });

        // Reter a instancia para virar a tela sem perder as informacoes
        if (mPlayerHistory == null){
            if (task == null){
                task = new LoLShineTask();
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                String summonerName = sharedPreferences.getString(getString(R.string.pref_summoner_name_key),getString(R.string.pref_summoner_name_default));
                if (summonerName != null && !summonerName.isEmpty()){
                    task.execute(summonerName.replace(" ","").toLowerCase());
                }
                searchPlayer();
            } else if (task.getStatus() == AsyncTask.Status.FINISHED){
                fillGameList();
            }
        } else {
            fillGameList();
        }
        return view;
    }

    public class LoLShineTask extends AsyncTask<String, Void, List<Game>> {
        @Override
        protected List<Game> doInBackground(String... params) {
            String url;
            OkHttpClient client = new OkHttpClient();
            Gson gson = new Gson();
            Request request;
            List<Game> pGames = null;

            try {
                String region = Utility.getRegionSetting(getActivity());
                // Pega o ID pelo nick
                url = "https://" + region + ".api.pvp.net/api/lol/" + region + "/v1.4/summoner/by-name/" +
                        params[0] +"?api_key=4508d11b-77d1-439b-8fad-48326122d306";

                request = new Request.Builder()
                        .url(url)
                        .build();
                Response response = client.newCall(request).execute();
                String json = response.body().string();
                JSONObject summoner = new JSONObject(json);
                JSONObject summonerData = summoner.getJSONObject(params[0]);

                mSummonerId = summonerData.getLong("id");
                mSummonerName = summonerData.getString("name");
                mSummonerLevel = summonerData.getInt("summonerLevel");

                // Pega o historico de partidas pelo nick
                url = "https://" + region + ".api.pvp.net/api/lol/" + region + "/v1.3/game/by-summoner/" + String.valueOf(mSummonerId) +
                        "/recent?api_key=4508d11b-77d1-439b-8fad-48326122d306";

                request = new Request.Builder()
                        .url(url)
                        .build();
                response = client.newCall(request).execute();
                json = response.body().string();

                mPlayerHistory = gson.fromJson(json, PlayerHistory.class);
                pGames = mPlayerHistory.getGames();

            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }

            return pGames;
        }

        @Override
        protected void onPostExecute(List<Game> games) {
            super.onPostExecute(games);
            fillGameList();
        }
    }


    // Metodo que preenche a lista para ser utilizada sem perder o fragment
    private void fillGameList() {
        List<Game> games = new ArrayList<>();
        for (Game game : mPlayerHistory.getGames()){
            games.add(game);
        }
        mListView.setAdapter(new GameAdapter(getActivity(), games));
    }

    // Buscar o nick pela lupa
    public void searchPlayer(){
        if (null != searchView) {
            searchView.setSearchableInfo(searchManager
                    .getSearchableInfo(getActivity().getComponentName()));
            searchView.setIconifiedByDefault(false);
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    task = new LoLShineTask();
                    String summonerName = query.replace(" ", "").toLowerCase();
                    task.execute(summonerName);
                    return true;
                }
                @Override
                public boolean onQueryTextChange(String newText) {
                    return true;
                }
            });
        }
    }
}

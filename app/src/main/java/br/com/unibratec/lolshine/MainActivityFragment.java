package br.com.unibratec.lolshine;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
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
import java.util.List;


public class MainActivityFragment extends Fragment {
    private PlayerHistory mPlayerHistory;
    private ListView mListView;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        LoLShineTask task = new LoLShineTask();

        String summonerName = "Coexista".toLowerCase();
        task.execute(summonerName);

        mListView = (ListView) view.findViewById(R.id.listView_matches);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(getActivity(), GameDetailActivity.class);
                Game game = mPlayerHistory.getGames().get(i);
                it.putExtra("game", game);
                startActivity(it);
            }
        });

        return view;
    }

    public class LoLShineTask extends AsyncTask<String, Void, List<Game>>{

        @Override
        protected List<Game> doInBackground(String... params) {
            String url;
            OkHttpClient client = new OkHttpClient();
            Gson gson = new Gson();
            Request request = null;

            try {
                url = "https://br.api.pvp.net/api/lol/br/v1.4/summoner/by-name/" +
                        params[0] +"?api_key=4508d11b-77d1-439b-8fad-48326122d306";
                request = new Request.Builder()
                        .url(url)
                        .build();
                Response response = client.newCall(request).execute();
                String json = response.body().string();
                JSONObject summoner = new JSONObject(json);
                JSONObject summonerData = summoner.getJSONObject(params[0]);

                String summonerId = summonerData.getString("id");

                url = "https://br.api.pvp.net/api/lol/br/v1.3/game/by-summoner/" + summonerId +
                        "/recent?api_key=4508d11b-77d1-439b-8fad-48326122d306";

                request = new Request.Builder()
                        .url(url)
                        .build();
                response = client.newCall(request).execute();
                json = response.body().string();

                mPlayerHistory = gson.fromJson(json, PlayerHistory.class);

            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }

            return mPlayerHistory.getGames();
        }

        @Override
        protected void onPostExecute(List<Game> games) {
            mListView.setAdapter(new GameAdapter(getActivity(), games));
        }
    }
}

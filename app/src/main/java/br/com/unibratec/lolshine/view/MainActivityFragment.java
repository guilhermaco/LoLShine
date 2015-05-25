package br.com.unibratec.lolshine.view;


import android.app.SearchManager;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
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
import br.com.unibratec.lolshine.data.GameContract;
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
               // Intent it = new Intent(getActivity(), GameDetailActivity.class);
                Game game = mPlayerHistory.getGames().get(i);
               // it.putExtra("game", game);
               // startActivity(it);
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

                String summonerId = summonerData.getString("id");

                // Pega o historico de partidas pelo nick
                url = "https://" + region + ".api.pvp.net/api/lol/" + region + "/v1.3/game/by-summoner/" + summonerId +
                        "/recent?api_key=4508d11b-77d1-439b-8fad-48326122d306";

                request = new Request.Builder()
                        .url(url)
                        .build();
                response = client.newCall(request).execute();
                json = response.body().string();

                mPlayerHistory = gson.fromJson(json, PlayerHistory.class);
                pGames = mPlayerHistory.getGames();

                //insertGames(pGames, summonerId, params[0]);

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

    private void insertGames(List<Game> pGames, String summonerId, String param) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String summonerName = sharedPreferences.getString(getString(R.string.pref_summoner_name_key),getString(R.string.pref_summoner_name_default));
        if(param.equals(summonerName.replace(" ", "").toLowerCase())) {
            for (int i = 0; i < pGames.size(); i++) {
                int championId = pGames.get(i).getChampionId();
                int teamId = pGames.get(i).getTeamId();
                int timePlayed = pGames.get(i).getStats().getTimePlayed();
                int spell_1 = pGames.get(i).getSpell1();
                int spell_2 = pGames.get(i).getSpell2();
                int level = pGames.get(i).getStats().getLevel();
                int championsKilled = pGames.get(i).getStats().getChampionsKilled();
                int numDeath = pGames.get(i).getStats().getNumDeaths();
                int assist = pGames.get(i).getStats().getAssists();
                int minionsKilled = pGames.get(i).getStats().getMinionsKilled();
                int neutralMinionsKilled = pGames.get(i).getStats().getNeutralMinionsKilled();
                int totalDamageDealt = pGames.get(i).getStats().getTotalDamageDealt();
                int magicDamageDealtPlayer = pGames.get(i).getStats().getMagicDamageDealtPlayer();
                int physicalDamageDealtPlayer = pGames.get(i).getStats().getPhysicalDamageDealtPlayer();
                int physicalDamagetaken = pGames.get(i).getStats().getPhysicalDamageTaken();
                int magicDamageTaken = pGames.get(i).getStats().getMagicDamageTaken();
                int totalDamageDealtChampion = pGames.get(i).getStats().getTotalDamageDealtToChampions();
                int physicalDamageDealtChampion = pGames.get(i).getStats().getPhysicalDamageDealtToChampions();
                int magicDamageDealtChampion = pGames.get(i).getStats().getMagicDamageDealtToChampions();
                int largestKillingSpree = pGames.get(i).getStats().getLargestKillingSpree();
                int goldEarned = pGames.get(i).getStats().getGoldEarned();
                int largestMultKill = pGames.get(i).getStats().getLargestMultiKill();
                int killingSpree = pGames.get(i).getStats().getLargestKillingSpree();
                String win = pGames.get(i).getStats().isWin() ? "Win" : "Lose";

                ContentValues playerValues = new ContentValues();

                playerValues.put(GameContract.PlayerEntry.COLUMN_SUMMONER_ID, Long.valueOf(summonerId));
                playerValues.put(GameContract.PlayerEntry.COLUMN_CHAMPION_ID, championId);
                playerValues.put(GameContract.PlayerEntry.COLUMN_TEAM_ID, teamId);
                playerValues.put(GameContract.PlayerEntry.COLUMN_TIME_PLAYED, timePlayed);
                playerValues.put(GameContract.PlayerEntry.COLUMN_SPELL_1, spell_1);
                playerValues.put(GameContract.PlayerEntry.COLUMN_SPELL_2, spell_2);
                //  playerValues.put(GameContract.PlayerEntry.COLUMN_SUMMONER_LEVEL, );
                playerValues.put(GameContract.PlayerEntry.COLUMN_LEVEL, level);
                playerValues.put(GameContract.PlayerEntry.COLUMN_CHAMPIONS_KILLED, championsKilled);
                playerValues.put(GameContract.PlayerEntry.COLUMN_NUM_DEATHS, numDeath);
                playerValues.put(GameContract.PlayerEntry.COLUMN_ASSISTS, assist);
                playerValues.put(GameContract.PlayerEntry.COLUMN_MINIONS_KILLED, minionsKilled);
                playerValues.put(GameContract.PlayerEntry.COLUMN_NEUTRAL_MINIONS_KILLED, neutralMinionsKilled);
                playerValues.put(GameContract.PlayerEntry.COLUMN_TOTAL_DAMAGE_DEALT, totalDamageDealt);
                playerValues.put(GameContract.PlayerEntry.COLUMN_PHYSICAL_DAMAGE_DEALT_PLAYER, physicalDamageDealtPlayer);
                playerValues.put(GameContract.PlayerEntry.COLUMN_MAGIC_DAMAGE_DEALT_PLAYER, magicDamageDealtPlayer);
                playerValues.put(GameContract.PlayerEntry.COLUMN_PHYSICAL_DAMAGE_TAKEN, physicalDamagetaken);
                playerValues.put(GameContract.PlayerEntry.COLUMN_MAGIC_DAMAGE_TAKEN, magicDamageTaken);
                playerValues.put(GameContract.PlayerEntry.COLUMN_TOTAL_DAMAGE_DEALT_CHAMPIONS, totalDamageDealtChampion);
                playerValues.put(GameContract.PlayerEntry.COLUMN_PHYSICAL_DAMAGE_DEALT_CHAMPIONS, physicalDamageDealtChampion);
                playerValues.put(GameContract.PlayerEntry.COLUMN_MAGIC_DAMAGE_DEALT_CHAMPIONS, magicDamageDealtChampion);
                playerValues.put(GameContract.PlayerEntry.COLUMN_LARGEST_KILLING_SPREE, largestKillingSpree);
                playerValues.put(GameContract.PlayerEntry.COLUMN_GOLD_EARNED, goldEarned);
                playerValues.put(GameContract.PlayerEntry.COLUMN_LARGEST_MULTI_KILL, largestMultKill);
                playerValues.put(GameContract.PlayerEntry.COLUMN_KLLING_SPREES, killingSpree);
                playerValues.put(GameContract.PlayerEntry.COLUMN_WIN, win);

                Uri insertedUri = getActivity().getContentResolver().insert(
                        GameContract.PlayerEntry.CONTENT_URI,
                        playerValues
                );

                long playerId = ContentUris.parseId(insertedUri);


                long gameId = pGames.get(i).getGameId();
                String gameMode = pGames.get(i).getGameMode();
                String gameType = pGames.get(i).getGameType();
                String gameSubType = pGames.get(i).getSubType();
                String invalid = pGames.get(i).isInvalid() ? "true" : "false";

                ContentValues gameValues = new ContentValues();
                gameValues.put(GameContract.GameEntry.COLUMN_PLAYER_KEY, playerId);
                gameValues.put(GameContract.GameEntry.COLUMN_GAME_ID, gameId);
                gameValues.put(GameContract.GameEntry.COLUMN_GAME_MODE, gameMode);
                gameValues.put(GameContract.GameEntry.COLUMN_GAME_TYPE, gameType);
                gameValues.put(GameContract.GameEntry.COLUMN_GAME_SUBTYPE, gameSubType);
                gameValues.put(GameContract.GameEntry.COLUMN_INVALID, invalid);

                getActivity().getContentResolver().insert(
                        GameContract.GameEntry.CONTENT_URI,
                        gameValues
                );
            }
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

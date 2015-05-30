package br.com.unibratec.lolshine.view;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.unibratec.lolshine.R;
import br.com.unibratec.lolshine.model.Game;
import br.com.unibratec.lolshine.model.Player;
import br.com.unibratec.lolshine.model.Utility;


public class GamePlayersDetailActivityFragment extends Fragment {
    private GamePlayersDetailTask task;
    private ListView mListViewBlueTeam;
    private ListView mListViewPurpleTeam;
    private List<Player> mBluePlayers;
    private List<Player> mPurplePlayers;
    private Game mGame;


    public GamePlayersDetailActivityFragment() {
    }

    public static GamePlayersDetailActivityFragment newInstance(Game game){
        Bundle params = new Bundle();
        params.putSerializable("game", game);
        GamePlayersDetailActivityFragment gamePlayersDetailActivityFragment = new GamePlayersDetailActivityFragment();
        gamePlayersDetailActivityFragment.setArguments(params);
        return gamePlayersDetailActivityFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game_players_detail, container, false);

        mGame = (Game) getArguments().getSerializable("game");
        mListViewBlueTeam = (ListView) view.findViewById(R.id.listViewBlueTeam);
        mListViewPurpleTeam = (ListView) view.findViewById(R.id.listViewPurpleTeam);

        task = new GamePlayersDetailTask();
        task.execute(mGame);

        return view;
    }

    public class GamePlayersDetailTask extends AsyncTask<Game, Void, Void> {

        @Override
        protected Void doInBackground(Game... games) {
            String url;
            OkHttpClient client = new OkHttpClient();
            Request request;
            Response response;
            String json;

            final String PARTICIPANTS = "participants";
            final String TEAM_ID = "teamId";
            final String CHAMPION_ID = "championId";
            final String SPELL_1 = "spell1Id";
            final String SPELL_2 = "spell2Id";
            final String STATS = "stats";
            final String KILLS = "kills";
            final String DEATHS = "deaths";
            final String ASSISTS = "assists";

            try {
                String region = Utility.getRegionSetting(getActivity());
                url = "https://" + region + ".api.pvp.net/api/lol/" + region + "/v2.2/match/" + games[0].getGameId() + "?api_key=4508d11b-77d1-439b-8fad-48326122d306";
                request = new Request.Builder()
                        .url(url)
                        .build();

                response = client.newCall(request).execute();
                json = response.body().string();

                JSONObject game = new JSONObject(json);
                JSONArray participants = game.getJSONArray(PARTICIPANTS);


                mBluePlayers = new ArrayList<>();
                mPurplePlayers = new ArrayList<>();

                for (int i = 0; i < games[0].getPlayers().size()+1 ; i++) {
                    JSONObject playerJSON = participants.getJSONObject(i);
                    JSONObject statsJSON = playerJSON.getJSONObject(STATS);

                    int teamId = playerJSON.getInt(TEAM_ID);
                    int championId = playerJSON.getInt(CHAMPION_ID);
                    int spell1 = playerJSON.getInt(SPELL_1);
                    int spell2 = playerJSON.getInt(SPELL_2);
                    int kills = statsJSON.getInt(KILLS);
                    int deaths = statsJSON.getInt(DEATHS);
                    int assists = statsJSON.getInt(ASSISTS);

                    Player player = new Player();
                    player.setTeamId(teamId);
                    player.setChampionId(championId);
                    player.setSpell1(spell1);
                    player.setSpell2(spell2);
                    player.getGameStats().setChampionsKilled(kills);
                    player.getGameStats().setNumDeaths(deaths);
                    player.getGameStats().setAssists(assists);

                    if(player.getTeamId() == 100) {
                        mBluePlayers.add(player);
                    }
                    if(player.getTeamId() == 200){
                        mPurplePlayers.add(player);
                    }
                }

            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            fillBlueTeamList();
            fillPurpleTeamList();
        }
    }

    private void fillBlueTeamList() {
        mListViewBlueTeam.setAdapter(new BlueTeamAdapter(getActivity(), mBluePlayers));
    }

    private void fillPurpleTeamList() {
        mListViewPurpleTeam.setAdapter(new PurpleTeamAdapter(getActivity(), mPurplePlayers));
    }
}

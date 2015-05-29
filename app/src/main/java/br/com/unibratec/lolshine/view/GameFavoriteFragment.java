package br.com.unibratec.lolshine.view;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import br.com.unibratec.lolshine.R;
import br.com.unibratec.lolshine.data.GameContract;
import br.com.unibratec.lolshine.model.Game;
import br.com.unibratec.lolshine.model.OnItemSelectedCallback;

public class GameFavoriteFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final int ID_LOADER = 0;
    private ListView listView;
    private GameCursorAdapter adapter;


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new GameCursorAdapter(getActivity(), null, 0);
        getLoaderManager().initLoader(ID_LOADER, null, this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_game_favorite, container, false);

        listView = (ListView)v.findViewById(R.id.listView_favorites);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cursor cursor = adapter.getCursor();
                cursor.moveToPosition(i);

                Game game = new Game();
                game.setGameId(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_GAME_ID)));
                game.setGameMode(cursor.getString(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_GAME_MODE)));
                game.setGameType(cursor.getString(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_GAME_TYPE)));
                game.setSubType(cursor.getString(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_GAME_SUBTYPE)));
                if (cursor.getString(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_INVALID)).equals("true")){
                    game.setInvalid(true);
                } else {
                    game.setInvalid(false);
                }
                game.setSummonerId(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_SUMMONER_ID)));
                game.setChampionId(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_CHAMPION_ID)));
                game.setTeamId(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_TEAM_ID)));
                game.setSpell1(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_SPELL_1)));
                game.setSpell2(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_SPELL_2)));
                game.getStats().setLevel(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_LEVEL)));
                game.setSummonerName(cursor.getString(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_SUMMONER_NAME)));
                game.getStats().setTimePlayed(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_TIME_PLAYED)));
                game.getStats().setChampionsKilled(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_CHAMPIONS_KILLED)));
                game.getStats().setNumDeaths(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_NUM_DEATHS)));
                game.getStats().setAssists(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_ASSISTS)));
                game.getStats().setMinionsKilled(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_MINIONS_KILLED)));
                game.getStats().setNeutralMinionsKilled(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_NEUTRAL_MINIONS_KILLED)));
                game.getStats().setTotalDamageDealt(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_TOTAL_DAMAGE_DEALT)));
                game.getStats().setPhysicalDamageDealtPlayer(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_PHYSICAL_DAMAGE_DEALT_PLAYER)));
                game.getStats().setMagicDamageDealtPlayer(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_MAGIC_DAMAGE_DEALT_PLAYER)));
                game.getStats().setPhysicalDamageTaken(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_PHYSICAL_DAMAGE_TAKEN)));
                game.getStats().setMagicDamageTaken(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_MAGIC_DAMAGE_TAKEN)));
                game.getStats().setTotalDamageDealtToChampions(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_TOTAL_DAMAGE_DEALT_CHAMPIONS)));
                game.getStats().setPhysicalDamageDealtToChampions(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_PHYSICAL_DAMAGE_DEALT_CHAMPIONS)));
                game.getStats().setMagicDamageDealtToChampions(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_MAGIC_DAMAGE_DEALT_CHAMPIONS)));
                game.getStats().setLargestKillingSpree(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_LARGEST_KILLING_SPREE)));
                game.getStats().setGoldEarned(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_GOLD_EARNED)));
                game.getStats().setLargestMultiKill(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_LARGEST_MULTI_KILL)));
                game.getStats().setKillingSprees(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_KILLING_SPREES)));
                game.getStats().setItem0(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_ITEM_0)));
                game.getStats().setItem1(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_ITEM_1)));
                game.getStats().setItem2(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_ITEM_2)));
                game.getStats().setItem3(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_ITEM_3)));
                game.getStats().setItem4(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_ITEM_4)));
                game.getStats().setItem5(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_ITEM_5)));
                game.getStats().setItem6(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_ITEM_6)));
                game.getStats().setDoubleKills(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_DOUBLE_KILLS)));
                game.getStats().setTripleKills(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_TRIPLE_KILLS)));
                game.getStats().setQuadraKills(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_QUADRA_KILLS)));
                game.getStats().setPentaKills(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_PENTA_KILLS)));
                if (cursor.getString(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_WIN)).equals("true")){
                    game.getStats().setWin(true);
                } else {
                    game.getStats().setWin(false);
                }

                if (getActivity() instanceof OnItemSelectedCallback) {
                    ((OnItemSelectedCallback)getActivity()).onItemSelected(game);
                }

            }
        });

        return v;
    }


    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(getActivity(),
                GameContract.GameEntry.CONTENT_URI,
                null,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        adapter.swapCursor(cursor);
        listView.setAdapter(adapter);
    }

    @Override
    public void onLoaderReset(android.support.v4.content.Loader<Cursor> loader) {

    }
}


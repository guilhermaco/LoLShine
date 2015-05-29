package br.com.unibratec.lolshine.view;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.ShareActionProvider;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.unibratec.lolshine.R;
import br.com.unibratec.lolshine.data.GameContract;
import br.com.unibratec.lolshine.model.Game;
import br.com.unibratec.lolshine.model.Utility;

public class GameDetailFragment extends Fragment {
    private Game mGame;

    public GameDetailFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public static GameDetailFragment newInstance(Game game){
        Bundle params = new Bundle();
        params.putSerializable("game", game);
        GameDetailFragment gameDetailFragment = new GameDetailFragment();
        gameDetailFragment.setArguments(params);
        return gameDetailFragment;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_game_detail, menu);
        MenuItem menuItem;

        menuItem = menu.findItem(R.id.action_favorite);
        if (isFavorite(mGame)){
            menuItem.setIcon(R.drawable.ic_action_add_favorite);
        } else {
            menuItem.setIcon(R.drawable.ic_action_remove_favorite);
        }

        menuItem = menu.findItem(R.id.action_share);
        ShareActionProvider shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        // Attach an intent to this ShareActionProvider.
        if (shareActionProvider != null ) {
            shareActionProvider.setShareIntent(createShareForecastIntent());
        }
    }

    private Intent createShareForecastIntent() {
        String shareString = "CHAMPION: " + Utility.getChampionNameById(mGame.getChampionId())
                + "\nSCORE: " +
                mGame.getStats().getChampionsKilled()
                + "/" +
                mGame.getStats().getNumDeaths()
                + "/" +
                mGame.getStats().getAssists()
                + "\nMODE: " +
                mGame.getGameMode()
                + "\n#LoLShine";

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT,
                shareString);
        return shareIntent;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_favorite){
            int championId = mGame.getChampionId();
            int teamId = mGame.getTeamId();
            int timePlayed = mGame.getStats().getTimePlayed();
            int spell_1 = mGame.getSpell1();
            int spell_2 = mGame.getSpell2();
            int summonerLevel = mGame.getSummonerLevel();
            String summonerName = mGame.getSummonerName();
            int level = mGame.getStats().getLevel();
            int championsKilled = mGame.getStats().getChampionsKilled();
            int numDeath = mGame.getStats().getNumDeaths();
            int assist = mGame.getStats().getAssists();
            int minionsKilled = mGame.getStats().getMinionsKilled();
            int neutralMinionsKilled = mGame.getStats().getNeutralMinionsKilled();
            int totalDamageDealt = mGame.getStats().getTotalDamageDealt();
            int magicDamageDealtPlayer = mGame.getStats().getMagicDamageDealtPlayer();
            int physicalDamageDealtPlayer = mGame.getStats().getPhysicalDamageDealtPlayer();
            int physicalDamagetaken = mGame.getStats().getPhysicalDamageTaken();
            int magicDamageTaken = mGame.getStats().getMagicDamageTaken();
            int totalDamageDealtChampion = mGame.getStats().getTotalDamageDealtToChampions();
            int physicalDamageDealtChampion = mGame.getStats().getPhysicalDamageDealtToChampions();
            int magicDamageDealtChampion = mGame.getStats().getMagicDamageDealtToChampions();
            int largestKillingSpree = mGame.getStats().getLargestKillingSpree();
            int goldEarned = mGame.getStats().getGoldEarned();
            int largestMultKill = mGame.getStats().getLargestMultiKill();
            int killingSpree = mGame.getStats().getLargestKillingSpree();
            int item0 = mGame.getStats().getItem0();
            int item1 = mGame.getStats().getItem1();
            int item2 = mGame.getStats().getItem2();
            int item3 = mGame.getStats().getItem3();
            int item4 = mGame.getStats().getItem4();
            int item5 = mGame.getStats().getItem5();
            int item6 = mGame.getStats().getItem6();
            int doubleKills = mGame.getStats().getDoubleKills();
            int tripleKills = mGame.getStats().getTripleKills();
            int quadraKills = mGame.getStats().getQuadraKills();
            int pentaKills = mGame.getStats().getPentaKills();
            String win = mGame.getStats().isWin() ? "true" : "false";
            long gameId = mGame.getGameId();
            String gameMode = mGame.getGameMode();
            String gameType = mGame.getGameType();
            String gameSubType = mGame.getSubType();
            String invalid = mGame.isInvalid() ? "true" : "false";
            long summonerId = mGame.getSummonerId();

            ContentValues gameValues = new ContentValues();
            gameValues.put(GameContract.GameEntry.COLUMN_GAME_ID, gameId);
            gameValues.put(GameContract.GameEntry.COLUMN_GAME_MODE, gameMode);
            gameValues.put(GameContract.GameEntry.COLUMN_GAME_TYPE, gameType);
            gameValues.put(GameContract.GameEntry.COLUMN_GAME_SUBTYPE, gameSubType);
            gameValues.put(GameContract.GameEntry.COLUMN_INVALID, invalid);
            gameValues.put(GameContract.GameEntry.COLUMN_SUMMONER_ID, summonerId);
            gameValues.put(GameContract.GameEntry.COLUMN_CHAMPION_ID, championId);
            gameValues.put(GameContract.GameEntry.COLUMN_TEAM_ID, teamId);
            gameValues.put(GameContract.GameEntry.COLUMN_TIME_PLAYED, timePlayed);
            gameValues.put(GameContract.GameEntry.COLUMN_SPELL_1, spell_1);
            gameValues.put(GameContract.GameEntry.COLUMN_SPELL_2, spell_2);
            gameValues.put(GameContract.GameEntry.COLUMN_SUMMONER_LEVEL, summonerLevel);
            gameValues.put(GameContract.GameEntry.COLUMN_SUMMONER_NAME, summonerName);
            gameValues.put(GameContract.GameEntry.COLUMN_LEVEL, level);
            gameValues.put(GameContract.GameEntry.COLUMN_CHAMPIONS_KILLED, championsKilled);
            gameValues.put(GameContract.GameEntry.COLUMN_NUM_DEATHS, numDeath);
            gameValues.put(GameContract.GameEntry.COLUMN_ASSISTS, assist);
            gameValues.put(GameContract.GameEntry.COLUMN_MINIONS_KILLED, minionsKilled);
            gameValues.put(GameContract.GameEntry.COLUMN_NEUTRAL_MINIONS_KILLED, neutralMinionsKilled);
            gameValues.put(GameContract.GameEntry.COLUMN_TOTAL_DAMAGE_DEALT, totalDamageDealt);
            gameValues.put(GameContract.GameEntry.COLUMN_PHYSICAL_DAMAGE_DEALT_PLAYER, physicalDamageDealtPlayer);
            gameValues.put(GameContract.GameEntry.COLUMN_MAGIC_DAMAGE_DEALT_PLAYER, magicDamageDealtPlayer);
            gameValues.put(GameContract.GameEntry.COLUMN_PHYSICAL_DAMAGE_TAKEN, physicalDamagetaken);
            gameValues.put(GameContract.GameEntry.COLUMN_MAGIC_DAMAGE_TAKEN, magicDamageTaken);
            gameValues.put(GameContract.GameEntry.COLUMN_TOTAL_DAMAGE_DEALT_CHAMPIONS, totalDamageDealtChampion);
            gameValues.put(GameContract.GameEntry.COLUMN_PHYSICAL_DAMAGE_DEALT_CHAMPIONS, physicalDamageDealtChampion);
            gameValues.put(GameContract.GameEntry.COLUMN_MAGIC_DAMAGE_DEALT_CHAMPIONS, magicDamageDealtChampion);
            gameValues.put(GameContract.GameEntry.COLUMN_LARGEST_KILLING_SPREE, largestKillingSpree);
            gameValues.put(GameContract.GameEntry.COLUMN_GOLD_EARNED, goldEarned);
            gameValues.put(GameContract.GameEntry.COLUMN_LARGEST_MULTI_KILL, largestMultKill);
            gameValues.put(GameContract.GameEntry.COLUMN_KILLING_SPREES, killingSpree);
            gameValues.put(GameContract.GameEntry.COLUMN_ITEM_0, item0);
            gameValues.put(GameContract.GameEntry.COLUMN_ITEM_1, item1);
            gameValues.put(GameContract.GameEntry.COLUMN_ITEM_2, item2);
            gameValues.put(GameContract.GameEntry.COLUMN_ITEM_3, item3);
            gameValues.put(GameContract.GameEntry.COLUMN_ITEM_4, item4);
            gameValues.put(GameContract.GameEntry.COLUMN_ITEM_5, item5);
            gameValues.put(GameContract.GameEntry.COLUMN_ITEM_6, item6);
            gameValues.put(GameContract.GameEntry.COLUMN_DOUBLE_KILLS, doubleKills);
            gameValues.put(GameContract.GameEntry.COLUMN_TRIPLE_KILLS, tripleKills);
            gameValues.put(GameContract.GameEntry.COLUMN_QUADRA_KILLS, quadraKills);
            gameValues.put(GameContract.GameEntry.COLUMN_PENTA_KILLS, pentaKills);
            gameValues.put(GameContract.GameEntry.COLUMN_WIN, win);

            if (isFavorite(this.mGame)) {
                getActivity().getContentResolver().delete(
                        GameContract.GameEntry.CONTENT_URI,
                        GameContract.GameEntry.COLUMN_GAME_ID +" = ?",
                        new String[]{ String.valueOf(mGame.getGameId())}
                );
            } else {
                getActivity().getContentResolver().insert(
                        GameContract.GameEntry.CONTENT_URI,
                        gameValues
                );
            }
            getActivity().invalidateOptionsMenu();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean isFavorite(Game game){
        Cursor cursor = getActivity().getContentResolver().query(
                GameContract.GameEntry.CONTENT_URI,
                new String[]{ GameContract.GameEntry.COLUMN_GAME_ID },
                GameContract.GameEntry.COLUMN_GAME_ID  + " = ?",
                new String[]{String.valueOf(game.getGameId())},
                null);

        boolean isFavorite = cursor.moveToNext();
        cursor.close();
        return isFavorite;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_game_detail, container, false);

        mGame = (Game) getArguments().getSerializable("game");

        TextView txtSummonerName = (TextView) view.findViewById(R.id.textView_summonerName);
        TextView txtTimePlayed = (TextView) view.findViewById(R.id.textView_timePlayed);
        TextView txtLevel = (TextView) view.findViewById(R.id.textView_level);
        TextView txtChampionsKilled = (TextView) view.findViewById(R.id.textView_championsKilled);
        TextView txtNumDeaths = (TextView) view.findViewById(R.id.textView_numDeaths);
        TextView txtAssists = (TextView) view.findViewById(R.id.textView_assists);
        TextView txtMinionsKilled = (TextView) view.findViewById(R.id.textView_minionsKilled);
        TextView txtNeutralMinionsKilled = (TextView) view.findViewById(R.id.textView_neutralMinionsKilled);
        TextView txtTotalDamageDelt = (TextView) view.findViewById(R.id.textView_totalDamageDealt);
        TextView txtPhysicalDamageDealtPlayer = (TextView) view.findViewById(R.id.textView_physicalDamageDealtPlayer);
        TextView txtMagicDamageDealtPlayer = (TextView) view.findViewById(R.id.textView_magicDamageDealtPlayer);
        TextView txtPhysicalDamageTaken = (TextView) view.findViewById(R.id.textView_physicalDamageTaken);
        TextView txtMagicDamageTaken = (TextView) view.findViewById(R.id.textView_magicDamageTaken);
        TextView txtPhysicalDamageDealtToChampions = (TextView) view.findViewById(R.id.textView_physicalDamageDealtToChampions);
        TextView txtMagicDamageDealtToChampions = (TextView) view.findViewById(R.id.textView_magicDamageDealtToChampions);
        TextView txtTotalDamageDealtToChampions = (TextView) view.findViewById(R.id.textView_totalDamageDealtToChampions);
        TextView txtLargestKillingSpree = (TextView) view.findViewById(R.id.textView_largestKillingSpree);
        TextView txtGoldEarned = (TextView) view.findViewById(R.id.textView_goldEarned);
        TextView txtLargestMultiKill = (TextView) view.findViewById(R.id.textView_largestMultiKill);

        txtSummonerName.setText("Summoner Name: " + mGame.getSummonerName());
        txtTimePlayed.setText("Time Played: " + String.valueOf(mGame.getStats().getTimePlayed()));
        txtLevel.setText("Level: " + String.valueOf(mGame.getStats().getLevel()));
        txtChampionsKilled.setText("Kills: " + String.valueOf(mGame.getStats().getChampionsKilled()));
        txtNumDeaths.setText("Deaths: " + String.valueOf(mGame.getStats().getNumDeaths()));
        txtAssists.setText("Assists: " + String.valueOf(mGame.getStats().getAssists()));
        txtMinionsKilled.setText("Minions Killed: " + String.valueOf(mGame.getStats().getMinionsKilled()));
        txtNeutralMinionsKilled.setText("Neutral Minions Killed: " + String.valueOf(mGame.getStats().getNeutralMinionsKilled()));
        txtTotalDamageDelt.setText("Total Damage Dealt: " + String.valueOf(mGame.getStats().getTotalDamageDealt()));
        txtPhysicalDamageDealtPlayer.setText("Physical Damage Dealt: " + String.valueOf(mGame.getStats().getPhysicalDamageDealtPlayer()));
        txtMagicDamageDealtPlayer.setText("Magic Damage Dealt: " + String.valueOf(mGame.getStats().getMagicDamageDealtPlayer()));
        txtPhysicalDamageTaken.setText("Physical Dagame Taken: " + String.valueOf(mGame.getStats().getPhysicalDamageTaken()));
        txtMagicDamageTaken.setText("Magic Damage Taken: " + String.valueOf(mGame.getStats().getMagicDamageTaken()));
        txtPhysicalDamageDealtToChampions.setText("Physical Damage Dealt To Champions: " + String.valueOf(mGame.getStats().getPhysicalDamageDealtToChampions()));
        txtMagicDamageDealtToChampions.setText("Magic Damage Dealt To Champions: " + String.valueOf(mGame.getStats().getMagicDamageDealtToChampions()));
        txtTotalDamageDealtToChampions.setText("Total Damage Dealt To Champions: " + String.valueOf(mGame.getStats().getTotalDamageDealtToChampions()));
        txtLargestKillingSpree.setText("Largest Killing Spree: " + String.valueOf(mGame.getStats().getLargestKillingSpree()));
        txtGoldEarned.setText("Gold Earned: " + String.valueOf(mGame.getStats().getGoldEarned()));
        txtLargestMultiKill.setText("Largest Multi Kill: " + String.valueOf(mGame.getStats().getLargestMultiKill()));

        return view;
    }
}

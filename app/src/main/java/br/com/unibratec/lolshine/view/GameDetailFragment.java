package br.com.unibratec.lolshine.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.unibratec.lolshine.R;
import br.com.unibratec.lolshine.model.Game;

public class GameDetailFragment extends Fragment {

    private Game mGame;

    public GameDetailFragment() {
    }

    public static GameDetailFragment newInstance(Game game){
        Bundle params = new Bundle();
        params.putSerializable("game", game);

        GameDetailFragment gameDetailFragment = new GameDetailFragment();
        gameDetailFragment.setArguments(params);

        return gameDetailFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_game_detail, container, false);

        mGame = (Game) getArguments().getSerializable("game");

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

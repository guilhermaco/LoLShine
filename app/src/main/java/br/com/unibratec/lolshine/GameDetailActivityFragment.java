package br.com.unibratec.lolshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class GameDetailActivityFragment extends Fragment {

    public GameDetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Intent it = getActivity().getIntent();
        Game game = (Game) it.getSerializableExtra("game");
        Log.d("GMC", game.getGameMode()+" "+ game.getStats().getChampionsKilled());

        return inflater.inflate(R.layout.fragment_game_detail, container, false);
    }
}

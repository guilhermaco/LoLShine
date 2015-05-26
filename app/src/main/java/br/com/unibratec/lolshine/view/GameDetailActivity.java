package br.com.unibratec.lolshine.view;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import br.com.unibratec.lolshine.R;
import br.com.unibratec.lolshine.model.Game;


public class GameDetailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_detail);
        if (savedInstanceState == null) {
            Game game = (Game) getIntent().getSerializableExtra("game");
            GameDetailFragment gameDetailFragment = GameDetailFragment.newInstance(game);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, gameDetailFragment)
                    .commit();
        }
    }
}

package br.com.unibratec.lolshine.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import br.com.unibratec.lolshine.R;
import br.com.unibratec.lolshine.model.Game;
import br.com.unibratec.lolshine.model.OnItemSelectedCallback;
import br.com.unibratec.lolshine.model.Utility;


public class MainActivity extends ActionBarActivity implements OnItemSelectedCallback {

    private boolean isTablet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String summonerName = sharedPreferences.getString(getString(R.string.pref_summoner_name_key),getString(R.string.pref_summoner_name_default));
        if (summonerName == null || summonerName.isEmpty()){
            startActivity(new Intent(this, SettingsActivity.class));
        }
        isTablet = Utility.isTablet(this);

        /*if (isTablet) {
            if (savedInstanceState == null) {
                Game game =

                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, GameDetailFragment.newInstance(game))
                        .commit();
            }
        }*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(Game game) {
       /* if(isTablet){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, GameDetailFragment.newInstance(game))
                    .commit();
        } else{
            Intent it = new Intent(this, DetailActivity.class);
            it.putExtra("weather_date", date);
            startActivity(it);
        }*/
    }
}

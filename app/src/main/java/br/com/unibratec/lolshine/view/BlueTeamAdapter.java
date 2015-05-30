package br.com.unibratec.lolshine.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.unibratec.lolshine.R;
import br.com.unibratec.lolshine.model.Player;
import br.com.unibratec.lolshine.model.Utility;


public class BlueTeamAdapter extends ArrayAdapter<Player> {

    public BlueTeamAdapter(Context context, List<Player> players) {
        super(context, 0, players);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_item_blue_player, null);
        }

        Player player = getItem(position);

        ImageView imgChampion = (ImageView)convertView.findViewById(R.id.imageView_champion);
        ImageView imgSpell1 = (ImageView)convertView.findViewById(R.id.imageView_spell1);
        ImageView imgSpell2 = (ImageView)convertView.findViewById(R.id.imageView_spell2);
        TextView txtKills = (TextView)convertView.findViewById(R.id.textView_kills);
        TextView txtDeaths = (TextView)convertView.findViewById(R.id.textView_deaths);
        TextView txtAssists = (TextView)convertView.findViewById(R.id.textView_assists);

        int championId = player.getChampionId();
        int spell1 = player.getSpell1();
        int spell2 = player.getSpell2();

        imgChampion.setImageResource(Utility.getChampionIconResource(championId));
        imgSpell1.setImageResource(Utility.getSummonerSpellIconResource(spell1));
        imgSpell2.setImageResource(Utility.getSummonerSpellIconResource(spell2));

        txtKills.setText(String.valueOf(player.getGameStats().getChampionsKilled()+"/"));
        txtDeaths.setText(String.valueOf(player.getGameStats().getNumDeaths()+"/"));
        txtAssists.setText(String.valueOf(player.getGameStats().getAssists()));

        return convertView;
    }
}

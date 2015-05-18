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
import br.com.unibratec.lolshine.model.Game;
import br.com.unibratec.lolshine.model.Utility;

public class GameAdapter extends ArrayAdapter<Game> {

    public GameAdapter(Context context, List<Game> games) {
        super(context, 0, games);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_item_matches, null);
        }
        Game game = getItem(position);

        ImageView imgChampion = (ImageView)convertView.findViewById(R.id.imageView_champion);
        TextView txtQueueType = (TextView)convertView.findViewById(R.id.textView_queueType);
        TextView txtWinnner = (TextView)convertView.findViewById(R.id.textView_winner);
        TextView txtKills = (TextView)convertView.findViewById(R.id.textView_kills);
        TextView txtDeaths = (TextView)convertView.findViewById(R.id.textView_deaths);
        TextView txtAssists = (TextView)convertView.findViewById(R.id.textView_assists);

        int championId = game.getChampionId();
        imgChampion.setImageResource(Utility.getChampionIconResource(championId));
        txtQueueType.setText(game.getGameMode());
        txtWinnner.setText(game.getStats().isWin() ? "WIN" : "LOSE");
        txtKills.setText(String.valueOf(game.getStats().getChampionsKilled()+"/"));
        txtDeaths.setText(String.valueOf(game.getStats().getNumDeaths()+"/"));
        txtAssists.setText(String.valueOf(game.getStats().getAssists()));

        return convertView;
    }
}

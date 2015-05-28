package br.com.unibratec.lolshine.view;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.unibratec.lolshine.R;
import br.com.unibratec.lolshine.data.GameContract;
import br.com.unibratec.lolshine.model.Utility;

public class GameCursorAdapter extends CursorAdapter {

    public GameCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.list_item_matches, null);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ImageView imgChampion = (ImageView)view.findViewById(R.id.imageView_champion);
        ImageView imgSpell1 = (ImageView)view.findViewById(R.id.imageView_spell1);
        ImageView imgSpell2 = (ImageView)view.findViewById(R.id.imageView_spell2);
        TextView txtQueueType = (TextView)view.findViewById(R.id.textView_queueType);
        TextView txtWinnner = (TextView)view.findViewById(R.id.textView_winner);
        TextView txtKills = (TextView)view.findViewById(R.id.textView_kills);
        TextView txtDeaths = (TextView)view.findViewById(R.id.textView_deaths);
        TextView txtAssists = (TextView)view.findViewById(R.id.textView_assists);

        int championId = cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_CHAMPION_ID));
        int spell1 = cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_SPELL_1));
        int spell2 = cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_SPELL_2));

        imgChampion.setImageResource(Utility.getChampionIconResource(championId));
        imgSpell1.setImageResource(Utility.getSummonerSpellIconResource(spell1));
        imgSpell2.setImageResource(Utility.getSummonerSpellIconResource(spell2));
        txtQueueType.setText(cursor.getString(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_GAME_MODE)));

        if(cursor.getString(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_WIN)).equals("true")) {
            txtWinnner.setText("WIN");
        }
        else{
            txtWinnner.setText("LOSE");
        }
        txtKills.setText(String.valueOf(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_CHAMPIONS_KILLED)) + "/"));
        txtDeaths.setText(String.valueOf(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_NUM_DEATHS)) + "/"));
        txtAssists.setText(String.valueOf(cursor.getInt(cursor.getColumnIndex(GameContract.GameEntry.COLUMN_ASSISTS))));
    }
}

package br.com.unibratec.lolshine.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.unibratec.lolshine.data.GameContract.GameEntry;

public class GamesDbHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "lolshine.db";
    public static final int CURRENT_VERSION = 1;

    public GamesDbHelper(Context context) {
        super(context, DATABASE_NAME, null, CURRENT_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_GAME_TABLE = "CREATE TABLE " + GameEntry.TABLE_NAME + " (" +
                GameEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                GameEntry.COLUMN_GAME_ID + " INTEGER NOT NULL, " +
                GameEntry.COLUMN_GAME_MODE + " TEXT NOT NULL, " +
                GameEntry.COLUMN_GAME_TYPE + " TEXT NOT NULL, " +
                GameEntry.COLUMN_GAME_SUBTYPE + " TEXT NOT NULL, " +
                GameEntry.COLUMN_INVALID + " TEXT, " +
                GameEntry.COLUMN_SUMMONER_ID + " INTEGER NOT NULL, " +
                GameEntry.COLUMN_CHAMPION_ID + " INTEGER NOT NULL, " +
                GameEntry.COLUMN_TEAM_ID + " INTEGER NOT NULL, " +
                GameEntry.COLUMN_SPELL_1 + " INTEGER, " +
                GameEntry.COLUMN_SPELL_2 + " INTEGER, " +
                GameEntry.COLUMN_SUMMONER_LEVEL + " INTEGER, " +
                GameEntry.COLUMN_LEVEL + " INTEGER, " +
                GameEntry.COLUMN_TIME_PLAYED + " INTEGER, " +
                GameEntry.COLUMN_CHAMPIONS_KILLED + " INTEGER, " +
                GameEntry.COLUMN_NUM_DEATHS + " INTEGER, " +
                GameEntry.COLUMN_ASSISTS + " INTEGER, " +
                GameEntry.COLUMN_MINIONS_KILLED + " INTEGER, " +
                GameEntry.COLUMN_NEUTRAL_MINIONS_KILLED + " INTEGER, " +
                GameEntry.COLUMN_TOTAL_DAMAGE_DEALT + " INTEGER, " +
                GameEntry.COLUMN_PHYSICAL_DAMAGE_DEALT_PLAYER + " INTEGER, " +
                GameEntry.COLUMN_MAGIC_DAMAGE_DEALT_PLAYER + " INTEGER, " +
                GameEntry.COLUMN_PHYSICAL_DAMAGE_TAKEN + " INTEGER, " +
                GameEntry.COLUMN_MAGIC_DAMAGE_TAKEN + " INTEGER, " +
                GameEntry.COLUMN_TOTAL_DAMAGE_DEALT_CHAMPIONS + " INTEGER, " +
                GameEntry.COLUMN_PHYSICAL_DAMAGE_DEALT_CHAMPIONS + " INTEGER, " +
                GameEntry.COLUMN_MAGIC_DAMAGE_DEALT_CHAMPIONS + " INTEGER, " +
                GameEntry.COLUMN_LARGEST_KILLING_SPREE + " INTEGER, " +
                GameEntry.COLUMN_GOLD_EARNED + " INTEGER, " +
                GameEntry.COLUMN_LARGEST_MULTI_KILL + " INTEGER, " +
                GameEntry.COLUMN_KLLING_SPREES + " INTEGER, " +
                GameEntry.COLUMN_ITEM_0 + " INTEGER, " +
                GameEntry.COLUMN_ITEM_1 + " INTEGER, " +
                GameEntry.COLUMN_ITEM_2 + " INTEGER, " +
                GameEntry.COLUMN_ITEM_3 + " INTEGER, " +
                GameEntry.COLUMN_ITEM_4 + " INTEGER, " +
                GameEntry.COLUMN_ITEM_5 + " INTEGER, " +
                GameEntry.COLUMN_ITEM_6 + " INTEGER, " +
                GameEntry.COLUMN_DOUBLE_KILLS + " INTEGER, " +
                GameEntry.COLUMN_TRIPLE_KILLS + " INTEGER, " +
                GameEntry.COLUMN_QUADRA_KILLS + " INTEGER, " +
                GameEntry.COLUMN_PENTA_KILLS + " INTEGER , " +
                GameEntry.COLUMN_WIN + " TEXT " + " )";

        db.execSQL(SQL_CREATE_GAME_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}

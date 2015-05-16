package br.com.unibratec.lolshine.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.unibratec.lolshine.data.GameContract.PlayerEntry;
import br.com.unibratec.lolshine.data.GameContract.GameEntry;

public class GamesDbHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "lolshine.db";
    public static final int CURRENT_VERSION = 1;

    public GamesDbHelper(Context context) {
        super(context, DATABASE_NAME, null, CURRENT_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_PLAYER_TABLE = "CREATE TABLE " + PlayerEntry.TABLE_NAME + " (" +
                PlayerEntry._ID + " INTEGER PRIMARY KEY," +
                PlayerEntry.COLUMN_CHAMPION_ID + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_TEAM_ID + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_SPELL_1 + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_SPELL_2 + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_SUMMONER_LEVEL + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_LEVEL + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_TIME_PLAYED + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_CHAMPIONS_KILLED + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_NUM_DEATHS + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_ASSISTS + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_MINIONS_KILLED + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_NEUTRAL_MINIONS_KILLED + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_TOTAL_DAMAGE_DEALT + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_PHYSICAL_DAMAGE_DEALT_PLAYER + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_MAGIC_DAMAGE_DEALT_PLAYER + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_PHYSICAL_DAMAGE_TAKEN + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_MAGIC_DAMAGE_TAKEN + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_TOTAL_DAMAGE_DEALT_CHAMPIONS + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_PHYSICAL_DAMAGE_DEALT_CHAMPIONS + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_MAGIC_DAMAGE_DEALT_CHAMPIONS + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_LARGEST_KILLING_SPREE + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_GOLD_EARNED + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_LARGEST_MULTI_KILL + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_KLLING_SPREES + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_ITEM_0 + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_ITEM_1 + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_ITEM_2 + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_ITEM_3 + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_ITEM_4 + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_ITEM_5 + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_ITEM_6 + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_DOUBLE_KILLS + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_TRIPLE_KILLS + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_QUADRA_KILLS + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_PENTA_KILLS + " INTEGER NOT NULL, " +
                PlayerEntry.COLUMN_WIN + " TEXT NOT NULL " +
                " );";

        final String SQL_CREATE_GAME_TABLE = "CREATE TABLE " + GameEntry.TABLE_NAME + " (" +
                GameEntry._ID + " INTEGER PRIMARY KEY," +
                GameEntry.COLUMN_GAME_MODE + " INTEGER NOT NULL, " +
                GameEntry.COLUMN_GAME_TYPE + " INTEGER NOT NULL, " +
                GameEntry.COLUMN_GAME_SUBTYPE + " INTEGER NOT NULL, " +
                GameEntry.COLUMN_INVALID + " TEXT NOT NULL, " +
                // Set up the location column as a foreign key to location table.
                " FOREIGN KEY (" + GameEntry.COLUMN_PLAYER_KEY + ") REFERENCES " +
                PlayerEntry.TABLE_NAME + " (" + PlayerEntry._ID + ");";

        db.execSQL(SQL_CREATE_PLAYER_TABLE);
        db.execSQL(SQL_CREATE_GAME_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}

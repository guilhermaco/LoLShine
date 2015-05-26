package br.com.unibratec.lolshine.data;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

public class GameContract {
    public static final String CONTENT_AUTHORITY = "br.com.unibratec.lolshine";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_GAME = "game";

    public static final class GameEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_GAME).build();

        public static final String TABLE_NAME = "game";

        public static final String COLUMN_GAME_ID = "game_id";
        public static final String COLUMN_GAME_MODE = "game_mode";
        public static final String COLUMN_GAME_TYPE = "game_type";
        public static final String COLUMN_GAME_SUBTYPE = "game_subtype";
        public static final String COLUMN_INVALID = "invalid";
        public static final String COLUMN_SUMMONER_ID = "summoner_id";
        public static final String COLUMN_CHAMPION_ID = "champion_id";
        public static final String COLUMN_TEAM_ID = "team_id";
        public static final String COLUMN_TIME_PLAYED = "time_played";
        public static final String COLUMN_SPELL_1 = "spell1";
        public static final String COLUMN_SPELL_2 = "spell2";
        public static final String COLUMN_SUMMONER_LEVEL = "summoner_level";
        public static final String COLUMN_LEVEL = "level";
        public static final String COLUMN_CHAMPIONS_KILLED = "champions_killed";
        public static final String COLUMN_NUM_DEATHS = "num_deaths";
        public static final String COLUMN_ASSISTS = "assists";
        public static final String COLUMN_MINIONS_KILLED = "minions_killed";
        public static final String COLUMN_NEUTRAL_MINIONS_KILLED = "neutral_minions_killed";
        public static final String COLUMN_TOTAL_DAMAGE_DEALT = "total_damage_dealt";
        public static final String COLUMN_PHYSICAL_DAMAGE_DEALT_PLAYER = "physical_damage_dealt_player";
        public static final String COLUMN_MAGIC_DAMAGE_DEALT_PLAYER = "magic_damage_dealt_player";
        public static final String COLUMN_PHYSICAL_DAMAGE_TAKEN = "physical_damage_taken";
        public static final String COLUMN_MAGIC_DAMAGE_TAKEN = "magic_damage_taken";
        public static final String COLUMN_TOTAL_DAMAGE_DEALT_CHAMPIONS = "total_damage_dealt_champions";
        public static final String COLUMN_PHYSICAL_DAMAGE_DEALT_CHAMPIONS = "physical_damage_dealt_champions";
        public static final String COLUMN_MAGIC_DAMAGE_DEALT_CHAMPIONS = "magic_damage_dealt_champions";
        public static final String COLUMN_LARGEST_KILLING_SPREE = "largest_killing_spree";
        public static final String COLUMN_GOLD_EARNED = "gold_earned";
        public static final String COLUMN_LARGEST_MULTI_KILL = "largest_multi_kill";
        public static final String COLUMN_KILLING_SPREES = "killing_sprees";
        public static final String COLUMN_ITEM_0 = "item_0";
        public static final String COLUMN_ITEM_1 = "item_1";
        public static final String COLUMN_ITEM_2 = "item_2";
        public static final String COLUMN_ITEM_3 = "item_3";
        public static final String COLUMN_ITEM_4 = "item_4";
        public static final String COLUMN_ITEM_5 = "item_5";
        public static final String COLUMN_ITEM_6 = "item_6";
        public static final String COLUMN_DOUBLE_KILLS = "double_kills";
        public static final String COLUMN_TRIPLE_KILLS = "triple_kills";
        public static final String COLUMN_QUADRA_KILLS = "quadra_kills";
        public static final String COLUMN_PENTA_KILLS = "penta_kills";
        public static final String COLUMN_WIN = "win";

        public static Uri buildGameUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }
    }
}

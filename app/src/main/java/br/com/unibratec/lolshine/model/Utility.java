package br.com.unibratec.lolshine.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import br.com.unibratec.lolshine.R;

public class Utility {
    /**
     * Helper method to provide the region in the settings
     */
    public static String getRegionSetting(Context context){
        SharedPreferences preferences =
                PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(
                context.getString(R.string.pref_region_key),
                context.getString(R.string.pref_region_default));
    }
    /**
     * Helper method to provide the summoner name in the settings
     */
    public static String getSummonerNameSetting(Context context){
        SharedPreferences preferences =
                PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(
                context.getString(R.string.pref_summoner_name_key),
                context.getString(R.string.pref_summoner_name_default));
    }
    /**
     * Helper method to provide the champion name according to the champion id returned
     */
    public static  boolean isTablet(Context context){
        return context.getResources().getBoolean(R.bool.isTablet);
    }

    /**
     * Helper method to provide the champion name according to the champion id returned
     */
    public static String getChampionNameById(int championId) {
        switch (championId) {
            case 266:
                return "AATROX";
            case 103:
                return "AHRI";
            case 84:
                return "AKALI";
            case 12:
                return "ALISTAR";
            case 32:
                return "AMUMU";
            case 34:
                return "ANIVIA";
            case 1:
                return "ANNIE";
            case 22:
                return "ASHE";
            case 268:
                return "AZIR";
            case 432:
                return "BARD";
            case 53:
                return "BLITZCRANK";
            case 63:
                return "BRAND";
            case 201:
                return "BRAUM";
            case 51:
                return "CAITLYN";
            case 69:
                return "CASSIOPEIA";
            case 31:
                return "CHO'GATH";
            case 42:
                return "CORKI";
            case 122:
                return "DARIUS";
            case 131:
                return "DIANA";
            case 36:
                return "DR.MUNDO";
            case 119:
                return "DRAVEN";
            case 60:
                return "ELISE";
            case 28:
                return "EVELYNN";
            case 81:
                return "EZREAL";
            case 9:
                return "FIDDLESTICKS";
            case 114:
                return "FIORA";
            case 105:
                return "FIZZ";
            case 3:
                return "GALIO";
            case 41:
                return "GANGPLANK";
            case 86:
                return "GAREN";
            case 150:
                return "GNAR";
            case 79:
                return "GRAGAS";
            case 104:
                return "GRAVES";
            case 120:
                return "HECARIN";
            case 74:
                return "HEIMERDINGER";
            case 39:
                return "IRELIA";
            case 40:
                return "JANNA";
            case 59:
                return "JARVAN IV";
            case 24:
                return "JAX";
            case 126:
                return "JAYCE";
            case 222:
                return "JINX";
            case 429:
                return "KALISTA";
            case 43:
                return "KARMA";
            case 30:
                return "KARTHUS";
            case 38:
                return "KASSADIN";
            case 55:
                return "KATARINA";
            case 10:
                return "KAYLE";
            case 85:
                return "KENNEN";
            case 121:
                return "KHA'ZIX";
            case 96:
                return "KOG'MAW";
            case 7:
                return "LEBLANC";
            case 64:
                return "LEE SIN";
            case 89:
                return "LEONA";
            case 127:
                return "LISSANDRA";
            case 236:
                return "LUCIAN";
            case 117:
                return "LULU";
            case 99:
                return "LUX";
            case 54:
                return "MALPHITE";
            case 90:
                return "MALZAHAR";
            case 57:
                return "MAOKAI";
            case 11:
                return "MASTER YI";
            case 21:
                return "MISS FORTUNE";
            case 82:
                return "MORDERKAISER";
            case 25:
                return "MORGANA";
            case 267:
                return "NAMI";
            case 75:
                return "NASUS";
            case 111:
                return "NAUTILUS";
            case 76:
                return "NIDALEE";
            case 56:
                return "NOCTURNE";
            case 20:
                return "NUNU";
            case 2:
                return "OLAF";
            case 61:
                return "ORIANNA";
            case 80:
                return "PANTHEON";
            case 78:
                return "POPPY";
            case 133:
                return "QUINN";
            case 33:
                return "RAMMUS";
            case 421:
                return "REK'SAI";
            case 58:
                return "RENEKTON";
            case 107:
                return "RENGAR";
            case 92:
                return "RIVEN";
            case 68:
                return "RUMBLE";
            case 13:
                return "RYZE";
            case 113:
                return "SEJUANI";
            case 35:
                return "SHACO";
            case 98:
                return "SHEN";
            case 102:
                return "SHYVANA";
            case 27:
                return "SINGED";
            case 14:
                return "SION";
            case 15:
                return "SIVIR";
            case 72:
                return "SKARNER";
            case 37:
                return "SONA";
            case 16:
                return "SORAKA";
            case 50:
                return "SWAIN";
            case 134:
                return"SYNDRA";
            case 91:
                return "TALON";
            case 44:
                return "TARIC";
            case 17:
                return "TEEMO";
            case 412:
                return "THRESH";
            case 18:
                return "TRISTANA";
            case 48:
                return "TRUNDLE";
            case 23:
                return "TRYNDAMERE";
            case 29:
                return "TWICH";
            case 4:
                return "TWISTED FATE";
            case 77:
                return "UDYR";
            case 6:
                return "URGOT";
            case 110:
                return "VARUS";
            case 67:
                return "VAYNE";
            case 45:
                return "VEIGAR";
            case 161:
                return "VEL'KOZ";
            case 254:
                return "VI";
            case 112:
                return "VIKTOR";
            case 8:
                return "VLADIMIR";
            case 106:
                return "VOLIBEAR";
            case 19:
                return "WARWICK";
            case 62:
                return "WUKONG";
            case 101:
                return "XERATH";
            case 5:
                return "XIN ZHAO";
            case 157:
                return "YASUO";
            case 83:
                return "YORICK";
            case 124:
                return "ZAC";
            case 238:
                return "ZED";
            case 115:
                return "ZIGGS";
            case 26:
                return "ZILEAN";
            case 143:
                return "ZYRA";
            default:
                return "UNKNOWN CHAMPION";
        }
    }

    /**
     * Helper method to provide the icon resource id according to the champion id returned
     */
    public static int getChampionIconResource(int championId) {
        switch (championId) {
            case 266:
                return R.drawable.ic_aatrox_266;
            case 103:
                return R.drawable.ic_ahri_103;
            case 84:
                return R.drawable.ic_akali_84;
            case 12:
                return R.drawable.ic_alistar_12;
            case 32:
                return R.drawable.ic_amumu_32;
            case 34:
                return R.drawable.ic_anivia_34;
            case 1:
                return R.drawable.ic_annie_1;
            case 22:
                return R.drawable.ic_ashe_22;
            case 268:
                return R.drawable.ic_azir_268;
            case 432:
                return R.drawable.ic_bard_432;
            case 53:
                return R.drawable.ic_blitzcrank_53;
            case 63:
                return R.drawable.ic_brand_63;
            case 201:
                return R.drawable.ic_braum_201;
            case 51:
                return R.drawable.ic_caitlyn_51;
            case 69:
                return R.drawable.ic_cassiopeia_69;
            case 31:
                return R.drawable.ic_chogath_31;
            case 42:
                return R.drawable.ic_corki_42;
            case 122:
                return R.drawable.ic_darius_122;
            case 131:
                return R.drawable.ic_diana_131;
            case 36:
                return R.drawable.ic_dr_mundo_36;
            case 119:
                return R.drawable.ic_draven_119;
            case 60:
                return R.drawable.ic_elise_60;
            case 28:
                return R.drawable.ic_evelynn_28;
            case 81:
                return R.drawable.ic_ezreal_81;
            case 9:
                return R.drawable.ic_fiddlesticks_9;
            case 114:
                return R.drawable.ic_fiora_114;
            case 105:
                return R.drawable.ic_fizz_105;
            case 3:
                return R.drawable.ic_galio_3;
            case 41:
                return R.drawable.ic_gangplank_41;
            case 86:
                return R.drawable.ic_garen_86;
            case 150:
                return R.drawable.ic_gnar_150;
            case 79:
                return R.drawable.ic_gragas_79;
            case 104:
                return R.drawable.ic_graves_104;
            case 120:
                return R.drawable.ic_hecarin_120;
            case 74:
                return R.drawable.ic_heimerdinger_74;
            case 39:
                return R.drawable.ic_irelia_39;
            case 40:
                return R.drawable.ic_janna_40;
            case 59:
                return R.drawable.ic_jarvan_iv_59;
            case 24:
                return R.drawable.ic_jax_24;
            case 126:
                return R.drawable.ic_jayce_126;
            case 222:
                return R.drawable.ic_jinx_222;
            case 429:
                return R.drawable.ic_kalista_429;
            case 43:
                return R.drawable.ic_karma_43;
            case 30:
                return R.drawable.ic_karthus_30;
            case 38:
                return R.drawable.ic_kassadin_38;
            case 55:
                return R.drawable.ic_katarina_55;
            case 10:
                return R.drawable.ic_kayle_10;
            case 85:
                return R.drawable.ic_kennen_85;
            case 121:
                return R.drawable.ic_khazix_121;
            case 96:
                return R.drawable.ic_kogmaw_96;
            case 7:
                return R.drawable.ic_leblanc_7;
            case 64:
                return R.drawable.ic_lee_sin_64;
            case 89:
                return R.drawable.ic_leona_89;
            case 127:
                return R.drawable.ic_lissandra_127;
            case 236:
                return R.drawable.ic_lucian_236;
            case 117:
                return R.drawable.ic_lulu_117;
            case 99:
                return R.drawable.ic_lux_99;
            case 54:
                return R.drawable.ic_malphite_54;
            case 90:
                return R.drawable.ic_malzahar_90;
            case 57:
                return R.drawable.ic_maokai_57;
            case 11:
                return R.drawable.ic_master_yi_11;
            case 21:
                return R.drawable.ic_miss_fortune_21;
            case 82:
                return R.drawable.ic_morderkaiser_82;
            case 25:
                return R.drawable.ic_morgana_25;
            case 267:
                return R.drawable.ic_nami_267;
            case 75:
                return R.drawable.ic_nasus_75;
            case 111:
                return R.drawable.ic_nautilus_111;
            case 76:
                return R.drawable.ic_nidalee_76;
            case 56:
                return R.drawable.ic_nocturne_56;
            case 20:
                return R.drawable.ic_nunu_20;
            case 2:
                return R.drawable.ic_olaf_2;
            case 61:
                return R.drawable.ic_orianna_61;
            case 80:
                return R.drawable.ic_pantheon_80;
            case 78:
                return R.drawable.ic_poppy_78;
            case 133:
                return R.drawable.ic_quinn_133;
            case 33:
                return R.drawable.ic_rammus_33;
            case 421:
                return R.drawable.ic_reksai_421;
            case 58:
                return R.drawable.ic_renekton_58;
            case 107:
                return R.drawable.ic_rengar_107;
            case 92:
                return R.drawable.ic_riven_92;
            case 68:
                return R.drawable.ic_rumble_68;
            case 13:
                return R.drawable.ic_ryze_13;
            case 113:
                return R.drawable.ic_sejuani_113;
            case 35:
                return R.drawable.ic_shaco_35;
            case 98:
                return R.drawable.ic_shen_98;
            case 102:
                return R.drawable.ic_shyvana_102;
            case 27:
                return R.drawable.ic_singed_27;
            case 14:
                return R.drawable.ic_sion_14;
            case 15:
                return R.drawable.ic_sivir_15;
            case 72:
                return R.drawable.ic_skarner_72;
            case 37:
                return R.drawable.ic_sona_37;
            case 16:
                return R.drawable.ic_soraka_16;
            case 50:
                return R.drawable.ic_swain_50;
            case 134:
                return R.drawable.ic_syndra_134;
            case 91:
                return R.drawable.ic_talon_91;
            case 44:
                return R.drawable.ic_taric_44;
            case 17:
                return R.drawable.ic_teemo_17;
            case 412:
                return R.drawable.ic_tresh_412;
            case 18:
                return R.drawable.ic_tristana_18;
            case 48:
                return R.drawable.ic_trundle_48;
            case 23:
                return R.drawable.ic_tryndamere_23;
            case 29:
                return R.drawable.ic_twich_29;
            case 4:
                return R.drawable.ic_twisted_fate_4;
            case 77:
                return R.drawable.ic_udyr_77;
            case 6:
                return R.drawable.ic_urgot_6;
            case 110:
                return R.drawable.ic_varus_110;
            case 67:
                return R.drawable.ic_vayne_67;
            case 45:
                return R.drawable.ic_veigar_45;
            case 161:
                return R.drawable.ic_velkoz_161;
            case 254:
                return R.drawable.ic_vi_254;
            case 112:
                return R.drawable.ic_viktor_112;
            case 8:
                return R.drawable.ic_vladimir_8;
            case 106:
                return R.drawable.ic_volibear_106;
            case 19:
                return R.drawable.ic_warwick_19;
            case 62:
                return R.drawable.ic_wukong_62;
            case 101:
                return R.drawable.ic_xerath_101;
            case 5:
                return R.drawable.ic_xin_zhao_5;
            case 157:
                return R.drawable.ic_yasuo_157;
            case 83:
                return R.drawable.ic_yorick_83;
            case 124:
                return R.drawable.ic_zac_124;
            case 238:
                return R.drawable.ic_zed_238;
            case 115:
                return R.drawable.ic_ziggz_115;
            case 26:
                return R.drawable.ic_zilean_26;
            case 143:
                return R.drawable.ic_zyra_143;
            default:
                return R.mipmap.ic_launcher;
        }
    }

    /**
     * Helper method to provide the icon resource id according to the summoner spell id returned
     */
    public static int getSummonerSpellIconResource(int summonerSpellId){
        switch (summonerSpellId){
            case 1:
                return R.drawable.ic_cleanse;
            case 12:
            return R.drawable.ic_teleport;
            case 14:
            return R.drawable.ic_ignite;
            case 6:
            return R.drawable.ic_ghost;
            case 31:
            case 32:
            return R.drawable.ic_mark;
            case 7:
            return R.drawable.ic_heal;
            case 11:
            return R.drawable.ic_smite;
            case 3:
            return R.drawable.ic_exhaust;
            case 13:
            return R.drawable.ic_clarity;
            case 2:
            return R.drawable.ic_clairvoyance;
            case 4:
            return R.drawable.ic_flash;
            case 8:
            return R.drawable.ic_garrison;
            case 21:
            return R.drawable.ic_barrier;
            default:
                return R.mipmap.ic_launcher;
        }
    }
}

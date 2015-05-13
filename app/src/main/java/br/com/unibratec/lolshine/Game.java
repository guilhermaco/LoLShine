package br.com.unibratec.lolshine;

import java.util.List;

public class Game {
    private long gameId;
    private boolean invalid;
    private String gameMode;
    private String gameType;
    private String subType;
    private int mapId;
    private int teamId;
    private int championId;
    private int spell1;
    private int spell2;
    private int level;
    private int ipEarned;
    private long createDate;
    private List<FellowPlayer> fellowPlayers;
    private GameStats stats;

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public boolean isInvalid() {
        return invalid;
    }

    public void setInvalid(boolean invalid) {
        this.invalid = invalid;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getChampionId() {
        return championId;
    }

    public void setChampionId(int championId) {
        this.championId = championId;
    }

    public int getSpell1() {
        return spell1;
    }

    public void setSpell1(int spell1) {
        this.spell1 = spell1;
    }

    public int getSpell2() {
        return spell2;
    }

    public void setSpell2(int spell2) {
        this.spell2 = spell2;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getIpEarned() {
        return ipEarned;
    }

    public void setIpEarned(int ipEarned) {
        this.ipEarned = ipEarned;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }

    public List<FellowPlayer> getFellowPlayers() {
        return fellowPlayers;
    }

    public void setFellowPlayers(List<FellowPlayer> fellowPlayers) {
        this.fellowPlayers = fellowPlayers;
    }

    public GameStats getStats() {
        return stats;
    }

    public void setStats(GameStats stats) {
        this.stats = stats;
    }
}

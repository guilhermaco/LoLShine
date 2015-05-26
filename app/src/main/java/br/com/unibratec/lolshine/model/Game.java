package br.com.unibratec.lolshine.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Game implements Serializable{
    private long gameId;
    private long summonerId;
    private boolean invalid;
    private String gameMode;
    private String gameType;
    private String subType;
    //          |
    // PLAYER! \/
    private int teamId;
    private int championId;
    private int spell1;
    private int spell2;
    private int level;
    private GameStats stats;
    // PLAYER! /\
    //         |
    private List<Player> fellowPlayers;

    public Game(){
        this.stats = new GameStats();
        this.fellowPlayers = new ArrayList<>();
    }

    public long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(long summonerId) {
        this.summonerId = summonerId;
    }

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

    public List<Player> getFellowPlayers() {
        return fellowPlayers;
    }

    public void setFellowPlayers(List<Player> fellowPlayers) {
        this.fellowPlayers = fellowPlayers;
    }

    public GameStats getStats() {
        return stats;
    }

    public void setStats(GameStats stats) {
        this.stats = stats;
    }
}

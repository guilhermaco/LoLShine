package br.com.unibratec.lolshine.model;

import java.io.Serializable;

public class Player implements Serializable{
    private long summonerId;
    private int champiomId;
    private int teamId;
    private GameStats gameStats;

    public long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(long summonerId) {
        this.summonerId = summonerId;
    }

    public int getChampiomId() {
        return champiomId;
    }

    public void setChampiomId(int champiomId) {
        this.champiomId = champiomId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public GameStats getGameStats() {
        return gameStats;
    }

    public void setGameStats(GameStats gameStats) {
        this.gameStats = gameStats;
    }
}

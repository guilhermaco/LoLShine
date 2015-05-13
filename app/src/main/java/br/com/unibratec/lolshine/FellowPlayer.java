package br.com.unibratec.lolshine;

public class FellowPlayer {
    private long summonerId;
    private int teamId;
    private int champiomId;

    public long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(long summonerId) {
        this.summonerId = summonerId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getChampiomId() {
        return champiomId;
    }

    public void setChampiomId(int champiomId) {
        this.champiomId = champiomId;
    }
}

package br.com.unibratec.lolshine.model;

import java.io.Serializable;

public class GameStats implements Serializable{
    private int timePlayed;
    private int level;
    private int championsKilled;
    private int numDeaths;
    private int assists;
    private int minionsKilled;
    private int neutralMinionsKilled;
    private int totalDamageDealt;
    private int physicalDamageDealtPlayer;
    private int magicDamageDealtPlayer;
    private int physicalDamageTaken;
    private int magicDamageTaken;
    private int totalDamageDealtToChampions;
    private int physicalDamageDealtToChampions;
    private int magicDamageDealtToChampions;
    private int largestKillingSpree;
    private int goldEarned;
    private int largestMultiKill;
    private int killingSprees;
    private int item0;
    private int item1;
    private int item2;
    private int item3;
    private int item4;
    private int item5;
    private int item6;
    private int doubleKills;
    private int tripleKills;
    private int quadraKills;
    private int pentaKills;
    private int team;
    private boolean win;

    public int getTimePlayed() {
        return timePlayed;
    }

    public void setTimePlayed(int timePlayed) {
        this.timePlayed = timePlayed;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getChampionsKilled() {
        return championsKilled;
    }

    public void setChampionsKilled(int championsKilled) {
        this.championsKilled = championsKilled;
    }

    public int getNumDeaths() {
        return numDeaths;
    }

    public void setNumDeaths(int numDeaths) {
        this.numDeaths = numDeaths;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getMinionsKilled() {
        return minionsKilled;
    }

    public void setMinionsKilled(int minionsKilled) {
        this.minionsKilled = minionsKilled;
    }

    public int getNeutralMinionsKilled() {
        return neutralMinionsKilled;
    }

    public void setNeutralMinionsKilled(int neutralMinionsKilled) {
        this.neutralMinionsKilled = neutralMinionsKilled;
    }

    public int getTotalDamageDealt() {
        return totalDamageDealt;
    }

    public void setTotalDamageDealt(int totalDamageDealt) {
        this.totalDamageDealt = totalDamageDealt;
    }

    public int getPhysicalDamageDealtPlayer() {
        return physicalDamageDealtPlayer;
    }

    public void setPhysicalDamageDealtPlayer(int physicalDamageDealtPlayer) {
        this.physicalDamageDealtPlayer = physicalDamageDealtPlayer;
    }

    public int getMagicDamageDealtPlayer() {
        return magicDamageDealtPlayer;
    }

    public void setMagicDamageDealtPlayer(int magicDamageDealtPlayer) {
        this.magicDamageDealtPlayer = magicDamageDealtPlayer;
    }

    public int getPhysicalDamageTaken() {
        return physicalDamageTaken;
    }

    public void setPhysicalDamageTaken(int physicalDamageTaken) {
        this.physicalDamageTaken = physicalDamageTaken;
    }

    public int getMagicDamageTaken() {
        return magicDamageTaken;
    }

    public void setMagicDamageTaken(int magicDamageTaken) {
        this.magicDamageTaken = magicDamageTaken;
    }

    public int getMagicDamageDealtToChampions() {
        return magicDamageDealtToChampions;
    }

    public void setMagicDamageDealtToChampions(int magicDamageDealtToChampions) {
        this.magicDamageDealtToChampions = magicDamageDealtToChampions;
    }

    public int getPhysicalDamageDealtToChampions() {
        return physicalDamageDealtToChampions;
    }

    public void setPhysicalDamageDealtToChampions(int physicalDamageDealtToChampions) {
        this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
    }

    public int getTotalDamageDealtToChampions() {
        return totalDamageDealtToChampions;
    }

    public void setTotalDamageDealtToChampions(int totalDamageDealtToChampions) {
        this.totalDamageDealtToChampions = totalDamageDealtToChampions;
    }

    public int getKillingSprees() {
        return killingSprees;
    }

    public void setKillingSprees(int killingSprees) {
        this.killingSprees = killingSprees;
    }

    public int getLargestKillingSpree() {
        return largestKillingSpree;
    }

    public void setLargestKillingSpree(int largestKillingSpree) {
        this.largestKillingSpree = largestKillingSpree;
    }

    public int getGoldEarned() {
        return goldEarned;
    }

    public void setGoldEarned(int goldEarned) {
        this.goldEarned = goldEarned;
    }

    public int getLargestMultiKill() {
        return largestMultiKill;
    }

    public void setLargestMultiKill(int largestMultiKill) {
        this.largestMultiKill = largestMultiKill;
    }

    public int getItem0() {
        return item0;
    }

    public void setItem0(int item0) {
        this.item0 = item0;
    }

    public int getItem1() {
        return item1;
    }

    public void setItem1(int item1) {
        this.item1 = item1;
    }

    public int getItem2() {
        return item2;
    }

    public void setItem2(int item2) {
        this.item2 = item2;
    }

    public int getItem3() {
        return item3;
    }

    public void setItem3(int item3) {
        this.item3 = item3;
    }

    public int getItem4() {
        return item4;
    }

    public void setItem4(int item4) {
        this.item4 = item4;
    }

    public int getItem5() {
        return item5;
    }

    public void setItem5(int item5) {
        this.item5 = item5;
    }

    public int getItem6() {
        return item6;
    }

    public void setItem6(int item6) {
        this.item6 = item6;
    }

    public int getDoubleKills() {
        return doubleKills;
    }

    public void setDoubleKills(int doubleKills) {
        this.doubleKills = doubleKills;
    }

    public int getTripleKills() {
        return tripleKills;
    }

    public void setTripleKills(int tripleKills) {
        this.tripleKills = tripleKills;
    }

    public int getQuadraKills() {
        return quadraKills;
    }

    public void setQuadraKills(int quadraKills) {
        this.quadraKills = quadraKills;
    }

    public int getPentaKills() {
        return pentaKills;
    }

    public void setPentaKills(int pentaKills) {
        this.pentaKills = pentaKills;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }


    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
}

package br.com.unibratec.lolshine;

import java.util.ArrayList;
import java.util.List;

public class PlayerHistory {
    private List<Game> games;

    public PlayerHistory(){
        this.games = new ArrayList<>();
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}

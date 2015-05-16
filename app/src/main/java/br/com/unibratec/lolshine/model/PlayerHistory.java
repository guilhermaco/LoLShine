package br.com.unibratec.lolshine.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PlayerHistory implements Serializable {
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

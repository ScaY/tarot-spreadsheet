package fr.isen.m2.jee.tarotspreadsheet.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Spreadsheet")
public class Spreadsheet extends Model {


    @NotNull
    private String name;

    @NotNull
    private int nbPlayer;

    @NotNull
    private String token;

    @OneToMany(mappedBy = "spreadsheet", fetch = FetchType.EAGER)
    private List<Player> players = new ArrayList<Player>();

    public Spreadsheet() {
        this("Hello", 5, "token");
    }

    public Spreadsheet(String name, int nbPlayer, String token) {
        this.name = name;
        this.nbPlayer = nbPlayer;
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNbPlayer() {
        return nbPlayer;
    }

    public void setNbPlayer(int nbPlayer) {
        this.nbPlayer = nbPlayer;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

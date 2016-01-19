package fr.isen.m2.jee.tarotspreadsheet.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name = Spreadsheet.NAME)
public class Spreadsheet extends Model {

    public static final String NAME = "Spreadsheet";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "spreadsheet", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderColumn(name = "index")
    private List<Player> players = new ArrayList<>();

    @NotNull
    private String name;

    @NotNull
    private int nbPlayer;

    @NotNull
    private String token;

    public Spreadsheet() {
        this("Null", 0, "Null");
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

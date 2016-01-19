package fr.isen.m2.jee.tarotspreadsheet.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Spreadsheet {

    public static final String TOKEN = "token";
    public static final String ID = "id";
    public static final String NB_PLAYER = "nbPlayer";
    public static final String NAME = "name";
    public static final String PLAYERS = "players";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String token;

    @NotNull
    private String name;

    @NotNull
    private int nbPlayer;

    @OneToMany(mappedBy = "spreadsheet", cascade = CascadeType.ALL)
    @OrderColumn(name = "index")
    private List<Player> players = new ArrayList<>();


    public Spreadsheet() {
        this(null, 0, null);
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

    public Long getId() {
        return id;
    }
}

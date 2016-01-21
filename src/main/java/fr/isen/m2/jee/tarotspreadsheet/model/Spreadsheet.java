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

    @OneToMany(mappedBy = "spreadsheet", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @OrderColumn(name = "index")
    private List<Player> players = new ArrayList<>();


    public Spreadsheet() {
        this(null, null);
    }

    public Spreadsheet(String token, String name) {
        this(token, name, new ArrayList<Player>());
    }

    public Spreadsheet(String token, String name, List<Player> players) {
        this.token = token;
        this.name = name;
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNbPlayer() {
        return this.getPlayers().size();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getPlayer(String name) {
        Player result = null;
        int i = 0;
        while (result == null && i < getNbPlayer()) {
            if (players.get(i).getName().equals(name)) {
                result = players.get(i);
            }
            i++;
        }
        return result;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public Player getPlayer(int i) {
        return players.get(i);
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

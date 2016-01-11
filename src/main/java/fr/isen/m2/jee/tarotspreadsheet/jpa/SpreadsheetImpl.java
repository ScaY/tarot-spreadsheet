package fr.isen.m2.jee.tarotspreadsheet.jpa;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "spreadsheet")
@NamedQueries({@NamedQuery(name = SpreadsheetImpl.ALL_ENTRIES, //
        query = "FROM spreadsheet ORDER BY name DESC"),//
        @NamedQuery(name = SpreadsheetImpl.ENTRIES_BY_NAME,//
                query = "FROM spreadsheet WHERE name = :name")})
public class SpreadsheetImpl implements Spreadsheet {

    public static final String ALL_ENTRIES = "ALL_ENTRIES";
    public static final String ENTRIES_BY_NAME = "ENTRIES_BY_NAME";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    private String name;
    private String token;
    private int nbPlayer;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private List<PlayerImpl> players = new ArrayList<PlayerImpl>();

    public SpreadsheetImpl() {
        this(-1, null, null);
    }

    public SpreadsheetImpl(int nbPlayer, String token, String name) {
        this.nbPlayer = nbPlayer;
        this.token = token;
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public String getToken() {
        return token;
    }


    public int getNbPlayer() {
        return nbPlayer;
    }


    public List<? extends Player> getPlayers() {
        return players;
    }


    public void addPlayer(Player player) {
        players.add(new PlayerImpl(this, player.getName()));
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public Long getId() {
        return id;
    }
}

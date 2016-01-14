package fr.isen.m2.jee.tarotspreadsheet.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = Spreadsheet.LIST, query = "select p from Spreadsheet p")
})
@XmlRootElement(name = "spreadsheet")
public class Spreadsheet extends Model {

    public static final String LIST = "spreadsheet.list";

    @NotNull
    private String name;

    @NotNull
    private int nbPlayer;

    @NotNull
    private String token;

    @OneToMany(mappedBy = "spreadsheet", fetch = FetchType.EAGER)
    private List<Player> players = new ArrayList<Player>();

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

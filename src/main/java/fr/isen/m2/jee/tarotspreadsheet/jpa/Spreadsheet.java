package fr.isen.m2.jee.tarotspreadsheet.jpa;

import java.util.List;

public interface Spreadsheet {

    Long getId();

    String getName();

    String getToken();

    int getNbPlayer();

    List<? extends Player> getPlayers();

    void addPlayer(Player player);

    void removePlayer(Player player);
}

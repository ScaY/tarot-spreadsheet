package fr.isen.m2.jee.tarotspreadsheet.dao;

import fr.isen.m2.jee.tarotspreadsheet.model.Player;
import fr.isen.m2.jee.tarotspreadsheet.model.Spreadsheet;

import java.util.List;

public class SpreadsheetAdapter {

    private Spreadsheet spreadsheet;

    private SpreadsheetDAO spreadsheetDAO;

    public SpreadsheetAdapter(Spreadsheet spreadsheet, SpreadsheetDAO spreadsheetDAO) {
        this.spreadsheet = spreadsheet;
        this.spreadsheetDAO = spreadsheetDAO;
    }

    public Spreadsheet getSpreadsheet() {
        return spreadsheet;
    }

    public String getToken() {
        return spreadsheet.getToken();
    }

    public String getName() {
        return spreadsheet.getName();
    }

    public List<Player> getPlayers() {
        return spreadsheet.getPlayers();
    }

    public int getNbPlayer() {
        return spreadsheet.getNbPlayer();
    }

    public Player getPlayer(int i) {
        return spreadsheet.getPlayer(i);
    }

    public void addPlayer(String name) {
        Player player = new Player(name, spreadsheet);
        spreadsheet.addPlayer(player);
        spreadsheetDAO.save(spreadsheet);
    }

    public void addScore(String name, int point, boolean isTaken, boolean isCalled, boolean isSuccess) {
        spreadsheet.getPlayer(name).addScore(point, isTaken, isCalled, isSuccess);
        spreadsheetDAO.save(spreadsheet);
    }

    public void addScore(int idPlayer, int point, boolean isTaken, boolean isCalled, boolean isSuccess) {
        spreadsheet.getPlayers().get(idPlayer).addScore(point, isTaken, isCalled, isSuccess);
        spreadsheetDAO.save(spreadsheet);
    }

}

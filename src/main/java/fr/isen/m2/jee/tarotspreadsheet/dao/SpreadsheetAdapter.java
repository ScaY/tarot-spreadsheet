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

    public int getNbPlayer() {
        return spreadsheet.getNbPlayer();
    }

    public Player getPlayer(int i){
        return spreadsheet.getPlayer(i);
    }
    public void addPlayer(String name) {
        spreadsheet.addPlayer(new Player(name, spreadsheet));
        spreadsheetDAO.save(spreadsheet);
    }

}

package fr.isen.m2.jee.tarotspreadsheet.web;

import fr.isen.m2.jee.tarotspreadsheet.dao.SpreadsheetAdapter;
import fr.isen.m2.jee.tarotspreadsheet.dao.SpreadsheetDAO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("spreadsheet")
@RequestScoped
public class SpreadsheetBean implements Serializable {

    SpreadsheetAdapter spreadsheetAdapter;

    @Inject
    SpreadsheetDAO dao;

    public SpreadsheetBean() {
    }

    public SpreadsheetBean(SpreadsheetAdapter spreadsheetAdapter) {
        this.spreadsheetAdapter = spreadsheetAdapter;
    }

    public int getNbPlayer() {
        return spreadsheetAdapter.getNbPlayer();
    }

    public SpreadsheetAdapter getSpreadsheetAdapter() {
        return spreadsheetAdapter;
    }

    public void createNewSpreadsheet(String name) {
        spreadsheetAdapter = dao.createNewSpreadsheet(name);
    }

    public void loadFromToken(String token) {
        spreadsheetAdapter = dao.loadFromToken(token);
    }

    public String getName() {
        return spreadsheetAdapter.getName();
    }

    public String getToken() {
        return spreadsheetAdapter.getToken();
    }

}

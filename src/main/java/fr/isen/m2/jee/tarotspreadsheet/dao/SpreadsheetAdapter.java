package fr.isen.m2.jee.tarotspreadsheet.dao;

import fr.isen.m2.jee.tarotspreadsheet.model.Spreadsheet;

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
}

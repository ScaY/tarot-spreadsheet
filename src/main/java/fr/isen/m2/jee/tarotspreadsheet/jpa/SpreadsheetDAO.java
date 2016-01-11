package fr.isen.m2.jee.tarotspreadsheet.jpa;

import java.util.List;

public interface SpreadsheetDAO {

    Spreadsheet createEntry(int nbPlayer, String token, String name);

    void saveEntry(Spreadsheet entry);

    List<Spreadsheet> getSpreadsheetByTitle(String name);

    List<Spreadsheet> getSpreadsheet();

}

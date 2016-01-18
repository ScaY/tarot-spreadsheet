package fr.isen.m2.jee.tarotspreadsheet.web;

import fr.isen.m2.jee.tarotspreadsheet.dao.SpreadsheetAdapter;
import fr.isen.m2.jee.tarotspreadsheet.dao.SpreadsheetDAO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named("spreadsheet")
@RequestScoped
public class SpreadsheetBean implements Serializable{

    SpreadsheetAdapter spreadsheetAdapter;

    @Inject
    SpreadsheetDAO dao;

    public void createNewSpreadsheet(){
        spreadsheetAdapter = dao.createNewSpreadsheet();
    }


    public int getNbPlayer(){
        return spreadsheetAdapter.getSpreadsheet().getNbPlayer();
    }
}

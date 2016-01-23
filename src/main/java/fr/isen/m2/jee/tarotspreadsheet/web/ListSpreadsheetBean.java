package fr.isen.m2.jee.tarotspreadsheet.web;

import fr.isen.m2.jee.tarotspreadsheet.dao.SpreadsheetDAO;
import fr.isen.m2.jee.tarotspreadsheet.model.Spreadsheet;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by stephane on 23/01/16.
 */

@Named("listSpreadsheet")
@RequestScoped
public class ListSpreadsheetBean implements Serializable {

    List<String> spreadsheetList;

    @Inject
    SpreadsheetDAO spreadsheetDAO;

    @PostConstruct
    public void init() {
        spreadsheetList = new LinkedList<>();
        for(Spreadsheet spreadsheet : spreadsheetDAO.getAll()){
            spreadsheetList.add(spreadsheet.getName());
        }
    }

    public void addSpreadsheetName(String name) {
        spreadsheetList.add(name);
    }

    public List<String> getSpreadsheetList() {
        return spreadsheetList;
    }
}

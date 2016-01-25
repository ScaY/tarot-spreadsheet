package fr.isen.m2.jee.tarotspreadsheet.web.Bean;

import fr.isen.m2.jee.tarotspreadsheet.dao.SpreadsheetDAO;
import fr.isen.m2.jee.tarotspreadsheet.model.Spreadsheet;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by stephane on 23/01/16.
 */

@Named("listSpreadsheet")
@RequestScoped
public class ListSpreadsheetBean implements Serializable {

    Map<String, String> spreadsheetList;

    @Inject
    SpreadsheetDAO spreadsheetDAO;

    @PostConstruct
    public void init() {
        spreadsheetList = new HashMap<>();
        for(Spreadsheet spreadsheet : spreadsheetDAO.getAll()){
            spreadsheetList.put(spreadsheet.getToken(), spreadsheet.getName());
        }
    }

    public Map<String, String> getSpreadsheetList() {
        return spreadsheetList;
    }
}

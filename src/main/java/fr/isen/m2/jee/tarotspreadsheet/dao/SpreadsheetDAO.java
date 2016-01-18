package fr.isen.m2.jee.tarotspreadsheet.dao;

import fr.isen.m2.jee.tarotspreadsheet.model.Spreadsheet;
import org.apache.commons.lang.RandomStringUtils;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;


public class SpreadsheetDAO {

    @Inject
    EntityManager em;

    @Inject
    UserTransaction ut;

    public SpreadsheetAdapter createNewSpreadsheet() {

        /*Spreadsheet spreadsheet = new Spreadsheet();
        spreadsheet.setToken(RandomStringUtils.randomAlphanumeric(10).toLowerCase());
        SpreadsheetAdapter spreadsheetAdapter = null;
        try {
            ut.begin();
            em.persist(spreadsheet);
            ut.commit();

        } catch (Exception e) {

        }*/
        return new SpreadsheetAdapter(new Spreadsheet(), this);
    }

}

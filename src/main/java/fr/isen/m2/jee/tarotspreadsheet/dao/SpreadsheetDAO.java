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

    public SpreadsheetAdapter createNewSpreadsheet(String name, int nbPlayer, String token) {

        Spreadsheet spreadsheet = new Spreadsheet(name, nbPlayer, token);
        try {
            ut.begin();
            em.persist(spreadsheet);
            ut.commit();

        } catch (Exception e) {

        }
        return new SpreadsheetAdapter(spreadsheet, this);
    }

    public SpreadsheetAdapter loadFromToken(String token) {
        Spreadsheet spreadsheet = (Spreadsheet) em
                .createQuery("SELECT s FROM Game s WHERE s.token = :token")
                .setParameter("token", token).getSingleResult();
        return new SpreadsheetAdapter(spreadsheet, this);
    }
}

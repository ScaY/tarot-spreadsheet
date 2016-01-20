package fr.isen.m2.jee.tarotspreadsheet.dao;

import fr.isen.m2.jee.tarotspreadsheet.model.Player;
import fr.isen.m2.jee.tarotspreadsheet.model.Spreadsheet;
import org.apache.commons.lang.RandomStringUtils;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.*;
import java.util.List;


public class SpreadsheetDAO {

    @Inject
    EntityManager em;

    @Inject
    UserTransaction ut;

    public SpreadsheetAdapter createNewSpreadsheet(String name) {

        String token = RandomStringUtils.randomAlphanumeric(10).toLowerCase();
        Spreadsheet spreadsheet = new Spreadsheet(token, name);
        try {
            ut.begin();
            em.persist(spreadsheet);
            ut.commit();

        } catch (Exception e) {

        }
        return new SpreadsheetAdapter(spreadsheet, this);
    }

    public SpreadsheetAdapter loadFromToken(String token) {
        Spreadsheet game = (Spreadsheet) em
                .createQuery("SELECT s FROM Spreadsheet s WHERE s.token = :token")
                .setParameter("token", token).getSingleResult();

        return new SpreadsheetAdapter(game, this);
    }

    public void save(Spreadsheet spreadsheet) {
        try {
            ut.begin();
            em.merge(spreadsheet);
            ut.commit();
        } catch (SecurityException | IllegalStateException | RollbackException
                | HeuristicMixedException | HeuristicRollbackException
                | SystemException | NotSupportedException e) {
            e.printStackTrace();
        }

    }
}

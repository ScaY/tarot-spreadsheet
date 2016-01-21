package fr.isen.m2.jee.tarotspreadsheet.dao;

import fr.isen.m2.jee.tarotspreadsheet.model.Player;
import fr.isen.m2.jee.tarotspreadsheet.model.Score;
import fr.isen.m2.jee.tarotspreadsheet.model.Spreadsheet;
import org.apache.commons.lang.RandomStringUtils;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.transaction.*;
import java.util.List;


public class SpreadsheetDAO extends DAO {


    private static final String GET_ALL_SPREADSHEET = "SELECT s FROM Spreadsheet s WHERE s.token = :token";

    /**
     * Create a spreadsheet adapter with a name
     * @param name the name to the new spreasheet to create
     * @return a spreadsheet adapter
     */
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

    /**
     * Retrieve a spreadsheet from a token
     * @param token the token of the spreadsheet
     * @return a spreadsheet adapter corresponding to a token
     */
    public SpreadsheetAdapter loadFromToken(String token) {
        try {
            Spreadsheet game = (Spreadsheet) em
                    .createQuery(GET_ALL_SPREADSHEET)
                    .setParameter("token", token).getSingleResult();


            return new SpreadsheetAdapter(game, this);
        } catch (NoResultException e) {
            return null;
        }
    }

    /**
     * Delete a spreadsheet with a token
     * @param token token corresponding to the spreadsheet to delete
     */
    public void deleteFromToken(String token) {
        try {
            Spreadsheet spreadsheet = (Spreadsheet) em.createQuery(GET_ALL_SPREADSHEET).setParameter("token", token).getSingleResult();
            /*for (Player player : spreadsheet.getPlayers()){
                // Deleting the player's score
                scoreDAO.delete(player.getId());
                // Delete the player
                playerDAO.deleteById( player.getId());
            }*/

            // Deleting the spreadsheet
            ut.begin();
            em.remove(spreadsheet);
            ut.commit();
        } catch (SecurityException | IllegalStateException | RollbackException
                | HeuristicMixedException | HeuristicRollbackException
                | SystemException | NotSupportedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Save a spreadsheet
     * @param spreadsheet the current spreadsheet to save
     */
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

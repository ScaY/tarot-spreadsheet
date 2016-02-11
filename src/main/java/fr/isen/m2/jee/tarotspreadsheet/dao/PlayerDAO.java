package fr.isen.m2.jee.tarotspreadsheet.dao;

import fr.isen.m2.jee.tarotspreadsheet.model.Player;
import fr.isen.m2.jee.tarotspreadsheet.model.Spreadsheet;

import javax.persistence.NoResultException;
import javax.transaction.*;
import java.util.List;

/**
 * Created by stephane on 21/01/16.
 */
public class PlayerDAO extends DAO {


    private static final String GET_PLAYER = "SELECT p FROM Player p WHERE p.name = :nameP AND p.spreadsheet.id= :idS";
    private static final String GET_PLAYER_BY_ID = "SELECT p FROM Player p WHERE p.id = :id";

    public Player get(String namePlayer, Spreadsheet spreadsheet) {
        try {
            Long spreadsheetId = spreadsheet.getId();
            return (Player) em.createQuery(GET_PLAYER).setParameter("nameP", namePlayer).
                    setParameter("idS", spreadsheetId).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Player get(Long id) {
        try {
            return (Player) em.createQuery(GET_PLAYER_BY_ID).setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void delete(String playerName, Spreadsheet spreadsheet) {
        try {
            ut.begin();
            Long spreadsheetId = spreadsheet.getId();
            List<Player> players = em.createQuery(GET_PLAYER).setParameter("nameP", playerName).
                    setParameter("idS", spreadsheetId).getResultList();
            for (Player player : players) {
                em.remove(player);
            }
            ut.commit();
        } catch (SecurityException | IllegalStateException | RollbackException
                | HeuristicMixedException | HeuristicRollbackException
                | SystemException | NotSupportedException e) {
            e.printStackTrace();
        }
    }

    public void deleteById(Long id) {
        try {
            ut.begin();
            Player player = (Player) em.createQuery(GET_PLAYER_BY_ID).setParameter("id", id).getSingleResult();
            Player playerToRemove = em.merge(player);
            em.remove(playerToRemove);
            ut.commit();
        } catch (SecurityException | IllegalStateException | RollbackException
                | HeuristicMixedException | HeuristicRollbackException
                | SystemException | NotSupportedException e) {
            e.printStackTrace();
        }
    }


}


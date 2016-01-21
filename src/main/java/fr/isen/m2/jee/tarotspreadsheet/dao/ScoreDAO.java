package fr.isen.m2.jee.tarotspreadsheet.dao;

import fr.isen.m2.jee.tarotspreadsheet.model.Score;

import javax.persistence.NoResultException;
import javax.transaction.*;
import java.util.List;

/**
 * Created by stephane on 21/01/16.
 */
public class ScoreDAO extends DAO {

    private static final String GET_SCORE_BY_POINT = "SELECT s FROM Score s WHERE s.point = :point";
    private static final String GET_SCORE_BY_ID = "SELECT s FROM Score s WHERE s.id = :id";
    private static final String GET_SCORE_BY_PLAYER_ID = "SELECT s FROM Score s WHERE s.player.id = :playerId";
    private static final String GET_SCORE_BY_PLAYER_ID_AND_POINT = "SELECT s FROM Score s WHERE s.player.id = :playerId and s.point = :point";
    private static final String GET_ALL_SCORE = "SELECT s FROM Score s WHERE s.point >= 0";

    public Score get(Long playerId, int point) {
        try {
            return (Score) em.createQuery(GET_SCORE_BY_PLAYER_ID_AND_POINT).setParameter("playerId", playerId).
                    setParameter("point", point).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Score> getAll() {
        try {
            return em.createQuery(GET_ALL_SCORE).getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Score get(Long id) {
        try {
            return (Score) em.createQuery(GET_SCORE_BY_ID).setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void deleteFromPoint(int point) {
        try {
            ut.begin();
            List<Score> scores = em.createQuery(GET_SCORE_BY_POINT).setParameter("point", point).getResultList();
            for (Score s : scores) {
                em.remove(s);
            }
            ut.commit();
        } catch (SecurityException | IllegalStateException | RollbackException
                | HeuristicMixedException | HeuristicRollbackException
                | SystemException | NotSupportedException e) {
            e.printStackTrace();
        }
    }

    public void delete(Long playerId) {
        try {
            ut.begin();
            List<Score> scores = em.createQuery(GET_SCORE_BY_PLAYER_ID).setParameter("playerId", playerId).getResultList();
            for (Score s : scores) {
                em.remove(s);
            }
            ut.commit();
        } catch (SecurityException | IllegalStateException | RollbackException
                | HeuristicMixedException | HeuristicRollbackException
                | SystemException | NotSupportedException e) {
            e.printStackTrace();
        }

    }
}

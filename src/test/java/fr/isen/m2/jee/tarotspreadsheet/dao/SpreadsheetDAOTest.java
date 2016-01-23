package fr.isen.m2.jee.tarotspreadsheet.dao;

import fr.isen.m2.jee.tarotspreadsheet.dao.guice.GuiceRunner;
import fr.isen.m2.jee.tarotspreadsheet.dao.guice.H2DBModule;
import fr.isen.m2.jee.tarotspreadsheet.dao.guice.Modules;
import fr.isen.m2.jee.tarotspreadsheet.model.Player;
import fr.isen.m2.jee.tarotspreadsheet.model.Score;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(GuiceRunner.class)
@Modules({H2DBModule.class, JPAModule.class})
public class SpreadsheetDAOTest {

    @Inject
    EntityManager em;

    @Inject
    SpreadsheetDAO spreadsheetDAO;

    @Inject
    PlayerDAO playerDAO;

    @Inject
    ScoreDAO scoreDAO;

    @Test
    public void daoIsInjected() throws Exception {
        assertThat(spreadsheetDAO).isNotNull();
        assertThat(playerDAO).isNotNull();
        assertThat(scoreDAO).isNotNull();
    }

    @Test
    public void itCanCreateASpreadsheet() throws Exception {
        em.clear();
        String name = "nameTest", namePlayer = "pTest";
        int nbPlayer = 5;
        // Create the spreadsheet
        SpreadsheetAdapter spreadsheet = spreadsheetDAO.createNewSpreadsheet(name);
        assertThat(spreadsheet).isNotNull();
        // Add player
        for (int i = 0; i < nbPlayer; i++) {
            spreadsheet.addPlayer(namePlayer + i);
        }
        // Reload the spreadsheet and check if has been added with the correct attributes
        String token = spreadsheet.getToken();
        assertThat(spreadsheet.getToken()).isNotNull();
        spreadsheet = spreadsheetDAO.loadFromToken(token);
        assertThat(spreadsheet).isNotNull();
        assertThat(spreadsheet.getName()).isEqualTo(name);
        assertThat(spreadsheet.getToken()).isEqualTo(token);
        assertThat(spreadsheet.getNbPlayer()).isEqualTo(nbPlayer);
        for (int i = 0; i < nbPlayer; i++) {
            Player p = spreadsheet.getPlayer(i);
            assertThat(p.getName()).isEqualTo(namePlayer + i);
            assertThat(p.getScores().isEmpty()).isEqualTo(true);
        }
    }

    @Test
    public void itCanAddScore() throws Exception {
        em.clear();
        String name = "nameTest2", namePlayer = "pTest2";
        int nbPlayer = 5;
        // Create the spreadsheet
        SpreadsheetAdapter spreadsheet = spreadsheetDAO.createNewSpreadsheet(name);
        // Add player and score
        for (int i = 0; i < nbPlayer; i++) {
            spreadsheet.addPlayer(namePlayer + i);
            spreadsheet.addScore(namePlayer + i, 0, false, false, false);
            spreadsheet.addScore(namePlayer + i, 1, false, false, false);
            spreadsheet.addScore(namePlayer + i, 4, false, false, false);
        }
        // Reload the spreadsheet and check if the scores have been added
        String token = spreadsheet.getToken();
        spreadsheet = spreadsheetDAO.loadFromToken(token);
        for (int i = 0; i < nbPlayer; i++) {
            Player p = spreadsheet.getPlayer(i);
            List<Score> scoreList = p.getScores();
            for (int j = 0; j < scoreList.size(); j++) {
                assertThat(scoreList.get(j).getPoint()).isEqualTo((int) Math.pow(j, 2));
            }
            assertThat(p.getLastScore().getPoint()).isEqualTo(4);
        }
    }

    @Test
    public void itCanRemoveASpreadsheet() throws Exception {
        em.clear();
        String name = "nameTest", namePlayer = "pTest3";
        int nbPlayer = 5;
        List<Long> idsPlayer = new LinkedList<>(), idsScore = new LinkedList<>();

        // Create the spreadsheet
        SpreadsheetAdapter spreadsheet = spreadsheetDAO.createNewSpreadsheet(name);
        for (int i = 0; i < nbPlayer; i++) {
            // Add player and score
            spreadsheet.addPlayer(namePlayer + i);
            spreadsheet.addScore(namePlayer + i, i, false, false, false);
            // Saving the score's id and player's id in order to the check if the score and the player
            // and have been deleted
            Long idPlayer = playerDAO.get(namePlayer + i, spreadsheet.getSpreadsheet()).getId();
            idsPlayer.add(idPlayer);
            idsScore.add(scoreDAO.get(idPlayer, i).getId());
        }

        // Deleting the spreadsheet
        String token = spreadsheet.getToken();
        spreadsheetDAO.deleteFromToken(token);
        spreadsheet = spreadsheetDAO.loadFromToken(token);

        // Check if the spreadsheet and the associated player and score
        // have been deleted
        assertThat(spreadsheet).isNull();
        assertThat(idsPlayer).isNotEmpty();
        for (Long idPlayer : idsPlayer) {
            assertThat(playerDAO.get(idPlayer)).isNull();
        }
        assertThat(idsScore).isNotEmpty();
        for (Long idScore : idsScore) {
            assertThat(scoreDAO.get(idScore)).isNull();
        }
    }


}

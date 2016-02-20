package fr.isen.m2.jee.tarotspreadsheet.web.servlet;

import fr.isen.m2.jee.tarotspreadsheet.core.RulesGame;
import fr.isen.m2.jee.tarotspreadsheet.model.Player;
import fr.isen.m2.jee.tarotspreadsheet.model.Score;
import fr.isen.m2.jee.tarotspreadsheet.model.Spreadsheet;
import fr.isen.m2.jee.tarotspreadsheet.web.Bean.SpreadsheetBean;
import fr.isen.m2.jee.tarotspreadsheet.web.ServletUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/addScore/*")
public class AddScoreServlet extends HttpServlet {

    @Inject
    SpreadsheetBean spreadsheetBean;

    private Spreadsheet spreadSheet; //nb player
    private int nbPlayer;
    private int takenPlayer;
    private int calledPlayer;
    private int nbBout;
    private int score;
    private int contrat;
    private String petitAuBout;
    private int poignee;
    private String poignee_equipe;
    private String chelem_equipe;
    private String chelem_score;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        spreadsheetBean.loadFromToken(ServletUtil.getTokenFromRequest(req));
        this.spreadSheet = spreadsheetBean.getSpreadsheetAdapter().getSpreadsheet();
        this.nbPlayer = this.spreadSheet.getNbPlayer();
        this.takenPlayer = Integer.valueOf(req.getParameter("joueur"));
        this.calledPlayer = Integer.valueOf(req.getParameter("appele"));
        this.nbBout = Integer.valueOf(req.getParameter("nb_bout"));
        this.contrat = Integer.valueOf(req.getParameter("contrat"));
        this.petitAuBout = req.getParameter("petit_au_bout");
        this.poignee = Integer.valueOf(req.getParameter("poignee"));
        this.poignee_equipe = req.getParameter("poignee_equipe");
        this.chelem_equipe = req.getParameter("chelem_equipe");
        this.chelem_score = req.getParameter("chelem_score");


        boolean scoreCheck = false;
        try {
            this.score = Integer.valueOf(req.getParameter("point"));
            scoreCheck = true;
        } catch (NumberFormatException e) {
            log("Error when retrieving the score");
        }

        if (!scoreCheck) {
            return;
        }

        log("NbPlayer " + nbPlayer);
        log("takenPlayer " + takenPlayer);
        log("calledPlaer " + calledPlayer);
        log("nbBout " + nbBout);
        log("score " + score);
        log("contrat " + contrat);
        log("petitaubout " + petitAuBout);
        log("poignee " + poignee);
        log("poigneeequie " + poignee_equipe);
        log("chelem equipe " + chelem_equipe);
        log("chelem score " + chelem_score);

        // Retrieving the score
        List<Score> scores = RulesGame.newScore(nbPlayer, takenPlayer, calledPlayer, nbBout, score, contrat, petitAuBout, poignee,
                poignee_equipe, chelem_equipe, chelem_score);

        // Adding the scores in the database
        for (int i = 0; i < scores.size(); i++) {
            Player currentPlayer = spreadsheetBean.getPlayers().get(i);
            Score currentScore = scores.get(i);
            log("THe score is : " + currentScore.getPoint() + " for " + currentPlayer.getName());
            currentScore.setPlayer(currentPlayer);
            spreadsheetBean.getSpreadsheetAdapter().addScore(i, currentScore.getPoint(), currentScore.isTaken(),
                    currentScore.isCalled(), currentScore.isSuccess());
        }

        resp.sendRedirect(req.getContextPath() + "/s/" + spreadsheetBean.getSpreadsheetAdapter().getSpreadsheet().getToken());
    }

}

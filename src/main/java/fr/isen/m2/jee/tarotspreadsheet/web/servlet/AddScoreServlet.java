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
    private int firstMisere;
    private int secondMisere;
    private int thirdMisere;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        spreadsheetBean.loadFromToken(ServletUtil.getTokenFromRequest(req));
        this.spreadSheet = spreadsheetBean.getSpreadsheetAdapter().getSpreadsheet();
        this.nbPlayer = this.spreadSheet.getNbPlayer();
        this.takenPlayer = Integer.valueOf(req.getParameter("joueur"));
        this.calledPlayer = Integer.valueOf(req.getParameter("appele"));
        this.nbBout = Integer.valueOf(req.getParameter("nb_bout"));
        this.score = Integer.valueOf(req.getParameter("point"));
        this.contrat = Integer.valueOf(req.getParameter("contrat"));
        this.petitAuBout = req.getParameter("petit_au_bout");
        this.poignee = Integer.valueOf(req.getParameter("poignee"));
        this.poignee_equipe = req.getParameter("poignee_equipe");
        this.chelem_equipe = req.getParameter("chelem_equipe");
        this.chelem_score = req.getParameter("chelem_score");
        this.firstMisere = Integer.valueOf(req.getParameter("misere_1"));
        this.secondMisere = Integer.valueOf(req.getParameter("misere_2"));
        this.thirdMisere = Integer.valueOf(req.getParameter("misere_3"));


        RulesGame rules = new RulesGame(this.spreadsheetBean.getPlayers());
        rules.newScore(nbPlayer, takenPlayer, calledPlayer, nbBout, score, contrat, petitAuBout, poignee, poignee_equipe, chelem_equipe, chelem_score);

        resp.sendRedirect(req.getContextPath() + "/s/" + spreadsheetBean.getSpreadsheetAdapter().getSpreadsheet().getToken());


    }
}

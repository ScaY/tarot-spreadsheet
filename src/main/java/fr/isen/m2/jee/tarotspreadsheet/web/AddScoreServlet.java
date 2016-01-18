package fr.isen.m2.jee.tarotspreadsheet.web;

import fr.isen.m2.jee.tarotspreadsheet.core.Bout;
import fr.isen.m2.jee.tarotspreadsheet.core.Contrat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addScore")
public class AddScoreServlet extends HttpServlet{

    private SpreadsheetBean spreadSheet; //nb player
    private int nbPlayer;
    private int takedPlayer;
    private int calledPlayer;
    private int nbBout;
    private int score;
    private int contrat;
    private String petitAuBout;
    private String poignee;
    private  String poignee_equipe;
    private String chelem_equipe;
    private String chelem_score;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
        this.spreadSheet = (SpreadsheetBean) req.getSession().getAttribute("spearsheet");
        this.nbPlayer = this.spreadSheet.getNbPlayer();
        this.takedPlayer  = Integer.valueOf(req.getParameter("joueur"));
        this.calledPlayer   = Integer.valueOf(req.getParameter("appele"));
        this.nbBout = Integer.valueOf(req.getParameter("nb_bout"));
        this.score = Integer.valueOf(req.getParameter("point"));
        this.contrat = Integer.valueOf(req.getParameter("contrat"));
        this.petitAuBout = req.getParameter("petit_au_bout");
        this.poignee  = req.getParameter("poignee");
        this.poignee_equipe  = req.getParameter("poignee_equipe");
        this.chelem_equipe = req.getParameter("chelem_equipe");

        int realScore = 0;
        boolean isSuccess = false;



        realScore = score - checknbBout(nbBout);

        if (petitAuBout == "attaque"){
            realScore += 10;
        }else if (petitAuBout == "defense"){
            realScore -= 10;
        }

        realScore = realScore * checkContrat(contrat);

        if (realScore >= 0){
            isSuccess = true;
        }else{
            realScore = - realScore;
        }

        realScore += checkChelem(chelem_equipe,chelem_score);


        //TODOOOOOOO rajouter gérer misere

       /* Player[] players = spreadSheet.getPlayers();

        for (int i = 0; i < nbPlayer;i++){
            if (i == takedPlayer){
                Player[i].addScore(getScore(players[i],realScore),true,false,isSuccess)
            } else if (i == calledPlayer){
                Player[i].addScore(getScore(players[i],realScore),false,true,isSuccess)
            }else{
                Player[i].addScore(getScore(players[i],realScore),false,false,false)

            }
        }*/
    }
    private int checkChelem(String equipe,String ChelemScore){
        int score = 0;
        if (equipe == "none"){
            return score;
        }

        if (ChelemScore == "callButNotDone"){
            score = -200;
        }else if (ChelemScore == "notCallButDone"){
            score = 200;
        }else{
            score = 400;
        }

        if (equipe == "attaque"){
            return score;
        }else{
            return -score;
        }
    }

    private int checknbBout(int nbBout){
        int musthaveValue = 0;
        switch(nbBout)
        {
            case 0 :
                musthaveValue =  Bout.GOT0.getValue();
                break;
            case 1 :
                musthaveValue = Bout.GOT1.getValue();
                break;
            case 2 :
                musthaveValue = Bout.GOT2.getValue();
                break;
            case 3 :
                musthaveValue = Bout.GOT3.getValue();
                break;
            default:
                break;
        }
        return musthaveValue;
    }

    private int checkContrat(int contrat){
        int multiplicator = 0;
        switch(contrat){
            case 1:
                multiplicator = Contrat.GARDE.getValue();
                break;
            case 2:
                multiplicator = Contrat.GARDESANS.getValue();
                break;
            case 3 :
                multiplicator = Contrat.GARDECONTRE.getValue();
                break;
            default:
                break;
        }
        return multiplicator;
    }
/*
    private int getScore(Player p,int realScore){
        int score = 0;
        if (nbPlayer == 4){
            if (p.getScore.isTaked){
                score = realScore * 3;
            }else{
                score = - realScore;
            }
        }else{
            if (p.getScore.isTaked){
                score = realScore * 2;
            }else if (p.getScore.isCalled) {
                score = realScore;
            }else{
                score = - realScore;
            }
        }
        return score;
    }
*/
}

package fr.isen.m2.jee.tarotspreadsheet.web;

import fr.isen.m2.jee.tarotspreadsheet.core.Bout;
import fr.isen.m2.jee.tarotspreadsheet.core.Contrat;
import fr.isen.m2.jee.tarotspreadsheet.model.Player;
import fr.isen.m2.jee.tarotspreadsheet.model.Score;
import fr.isen.m2.jee.tarotspreadsheet.model.Spreadsheet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/addScore")
public class AddScoreServlet extends HttpServlet{

    private Spreadsheet spreadSheet; //nb player
    private int nbPlayer;
    private int takenPlayer;
    private int calledPlayer;
    private int nbBout;
    private int score;
    private int contrat;
    private String petitAuBout;
    private int poignee;
    private  String poignee_equipe;
    private String chelem_equipe;
    private String chelem_score;
    private int firstMisere;
    private int secondMisere;
    private int thirdMisere;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {
        this.spreadSheet = (Spreadsheet) req.getSession().getAttribute("spearsheet");
        this.nbPlayer = this.spreadSheet.getNbPlayer();
        this.takenPlayer  = Integer.valueOf(req.getParameter("joueur"));
        this.calledPlayer   = Integer.valueOf(req.getParameter("appele"));
        this.nbBout = Integer.valueOf(req.getParameter("nb_bout"));
        this.score = Integer.valueOf(req.getParameter("point"));
        this.contrat = Integer.valueOf(req.getParameter("contrat"));
        this.petitAuBout = req.getParameter("petit_au_bout");
        this.poignee  = Integer.valueOf(req.getParameter("poignee"));
        this.poignee_equipe  = req.getParameter("poignee_equipe");
        this.chelem_equipe = req.getParameter("chelem_equipe");
        this.chelem_score = req.getParameter("chelem_score");
        this.firstMisere =  Integer.valueOf(req.getParameter("misere_1"));
        this.secondMisere =  Integer.valueOf(req.getParameter("misere_2"));
        this.thirdMisere =  Integer.valueOf(req.getParameter("misere_3"));




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



        List<Player> players = spreadSheet.getPlayers();

        for (int i = 0; i < nbPlayer;i++){
            Player p = players.get(i);
            if (i == takenPlayer){
               p.addScore(getScore(p,realScore),true,false,isSuccess);
            } else if (i == calledPlayer){
                p.addScore(getScore(p,realScore),false,true,isSuccess);
            }else{
                p.addScore(getScore(p,realScore),false,false,false);
            }
            checkMisery(players,firstMisere,nbPlayer);
            checkMisery(players,secondMisere,nbPlayer);
            checkMisery(players,thirdMisere,nbPlayer);
            checkPoigneeScore(players,poignee,poignee_equipe,isSuccess,nbPlayer);

        }
    }

    private void checkPoigneeScore(List<Player> players, int poignee, String equipe,boolean isSuccess,int nbPlayer){
        if (poignee != 0 && equipe != "none"){
            int poigneeScore = checkPoignee(poignee);

            if (isSuccess){
                for (Player p: players){
                    Score currentPlayerScore = p.getLastScore();

                    if (nbPlayer == 4){
                        if (currentPlayerScore.isTaken()){
                            currentPlayerScore.setPoint(currentPlayerScore.getPoint() + (poigneeScore * 3));
                        }else{
                            currentPlayerScore.setPoint(currentPlayerScore.getPoint() - poigneeScore);
                        }
                    }else{
                        if (currentPlayerScore.isTaken() || currentPlayerScore.isCalled())
                        {
                            currentPlayerScore.setPoint(currentPlayerScore.getPoint() + (poigneeScore * 3 / 2));
                        }else{
                            currentPlayerScore.setPoint(currentPlayerScore.getPoint() - poigneeScore);
                        }
                    }

                }
            }else{
                for (Player p: players){
                    Score currentPlayerScore = p.getLastScore();

                    if (nbPlayer == 4){
                        if (currentPlayerScore.isTaken()){
                            currentPlayerScore.setPoint(currentPlayerScore.getPoint() - (poigneeScore * 3));
                        }else{
                            currentPlayerScore.setPoint(currentPlayerScore.getPoint() + poigneeScore);
                        }
                    }else{
                        if (currentPlayerScore.isTaken() || currentPlayerScore.isCalled())
                        {
                            currentPlayerScore.setPoint(currentPlayerScore.getPoint() - (poigneeScore * 3 / 2));
                        }else{
                            currentPlayerScore.setPoint(currentPlayerScore.getPoint() + poigneeScore);
                        }
                    }

                }
            }

        }
    }

    private int checkPoignee(int poignee){
        switch(poignee){
            case 1:
                return 20;
            case 2:
                return 30;
            case 3:
                return 40;
            default:
                return 0;
        }
    }



    private void checkMisery(List<Player> players,int miseryPlayerIndex, int nbPlayer){
        if (miseryPlayerIndex != 0){
           for (int i = 0 ; i < nbPlayer;i++){
               if (i == miseryPlayerIndex){
                   players.get(miseryPlayerIndex).getLastScore().setPoint(players.get(miseryPlayerIndex).getLastScore().getPoint() + (10 * nbPlayer));
               }else{
                   players.get(i).getLastScore().setPoint(players.get(i).getLastScore().getPoint() - 10);
               }
           }
        }
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

    private int getScore(Player p,int realScore){
        int score = 0;
        if (nbPlayer == 4){
            if (p.getLastScore().isTaken()){
                score = realScore * 3;
            }else{
                score = - realScore;
            }
        }else{
            if (p.getLastScore().isTaken()){
                score = realScore * 2;
            }else if (p.getLastScore().isCalled()) {
                score = realScore;
            }else{
                score = - realScore;
            }
        }
        return score;
    }


}

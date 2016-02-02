package fr.isen.m2.jee.tarotspreadsheet.core;

import fr.isen.m2.jee.tarotspreadsheet.model.Player;
import fr.isen.m2.jee.tarotspreadsheet.model.Score;
import fr.isen.m2.jee.tarotspreadsheet.web.Bean.SpreadsheetBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renou on 25/01/16.
 */
public class RulesGame {

    private List<Player> players;


    public RulesGame(List<Player> players){
        this.players = players;
    }

    public void newScore(int nbPlayer,int takenPlayer,int calledPlayer,int nbBout,int score,int contrat,String petitAuBout, int poignee,String poignee_equipe, String chelem_equipe, String chelem_score){


        int realScore = 0;
        boolean isSuccess = false;


        realScore = score - checknbBout(nbBout);


        if (petitAuBout == "attaque") {
            realScore = realScore + 10;
        } else if (petitAuBout == "defense") {
            realScore -= 10;
        }

        realScore = realScore * checkContrat(contrat);


        if (realScore >= 0) {
            isSuccess = true;
        }

        realScore += checkChelem(chelem_equipe, chelem_score);

        for (int i = 0; i < nbPlayer; i++) {
            Player p = players.get(i);
            if (i == takenPlayer - 1) {
                p.addScore(getScore(p,realScore,nbPlayer,true,false), true, false, isSuccess);
            } else if (i == calledPlayer - 1) {
                p.addScore(getScore(p,realScore,nbPlayer,false,true), false, true, isSuccess);
            } else {
                p.addScore(getScore(p,realScore,nbPlayer,false,false), false, false, isSuccess);
            }

        }

        checkPoigneeScore(players, poignee, poignee_equipe, isSuccess, nbPlayer);


    }

    private void checkPoigneeScore(List<Player> players, int poignee, String equipe, boolean isSuccess, int nbPlayer) {
        if (poignee != 0 && equipe != "none") {
            int poigneeScore = checkPoignee(poignee);
            if (isSuccess) {
                for (Player p : players) {
                    if (p.getScores().size() > 0) {
                        Score currentPlayerScore = p.getLastScore();

                        if (nbPlayer == 4) {
                            if (currentPlayerScore.isTaken()) {
                                currentPlayerScore.setPoint(currentPlayerScore.getPoint() + (poigneeScore * 3));
                            } else {
                                currentPlayerScore.setPoint(currentPlayerScore.getPoint() - poigneeScore);
                            }
                        } else if (nbPlayer ==3) {
                            if (currentPlayerScore.isTaken()) {
                                currentPlayerScore.setPoint(currentPlayerScore.getPoint() + (poigneeScore * 2));
                            } else {
                                currentPlayerScore.setPoint(currentPlayerScore.getPoint() - poigneeScore);
                            }

                        }else{
                            if (currentPlayerScore.isTaken() || currentPlayerScore.isCalled()) {
                                currentPlayerScore.setPoint(currentPlayerScore.getPoint() + (poigneeScore * 3 / 2));
                            } else {
                                currentPlayerScore.setPoint(currentPlayerScore.getPoint() - poigneeScore);
                            }
                        }
                    }
                }
            } else {
                for (Player p : players) {
                    Score currentPlayerScore = p.getLastScore();

                    if (nbPlayer == 4) {
                        if (currentPlayerScore.isTaken()) {
                            currentPlayerScore.setPoint(currentPlayerScore.getPoint() - (poigneeScore * 3));
                        } else {
                            currentPlayerScore.setPoint(currentPlayerScore.getPoint() + poigneeScore);
                        }
                    } else {
                        if (currentPlayerScore.isTaken() || currentPlayerScore.isCalled()) {
                            currentPlayerScore.setPoint(currentPlayerScore.getPoint() - (poigneeScore * 3 / 2));
                        } else {
                            currentPlayerScore.setPoint(currentPlayerScore.getPoint() + poigneeScore);
                        }
                    }

                }
            }

        }
    }


    public int checkPoignee(int poignee) {
        switch (poignee) {
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



    public int checkChelem(String equipe, String ChelemScore) {
        int score = 0;
        if (equipe == "none") {
            return score;
        }

        if (ChelemScore == "callButNotDone") {
            score = -200;
        } else if (ChelemScore == "notCallButDone") {
            score = 200;
        } else {
            score = 400;
        }

        if (equipe == "attaque") {
            return score;
        } else {
            return -score;
        }
    }

    public int checknbBout(int nbBout) {
        int musthaveValue = 0;
        switch (nbBout) {
            case 0:
                musthaveValue = Bout.GOT0.getValue();
                break;
            case 1:
                musthaveValue = Bout.GOT1.getValue();
                break;
            case 2:
                musthaveValue = Bout.GOT2.getValue();
                break;
            case 3:
                musthaveValue = Bout.GOT3.getValue();
                break;
            default:
                break;
        }
        return musthaveValue;
    }

    public int checkContrat(int contrat) {
        int multiplicator = 1;
        switch (contrat) {
            case 1:
                multiplicator = Contrat.GARDE.getValue();
                break;
            case 2:
                multiplicator = Contrat.GARDESANS.getValue();
                break;
            case 3:
                multiplicator = Contrat.GARDECONTRE.getValue();
                break;
            default:
                break;
        }
        return multiplicator;
    }

    public int getScore(Player p, int realScore,int nbPlayer, boolean isTaken, boolean isCalled) {
        int score = 0;
        if (nbPlayer == 4) {
            if (isTaken) {
                score = realScore * 3;
            } else {
                score = -realScore;
            }
        } else {
            if (isTaken) {
                score = realScore * 2;
            } else if (isCalled) {
                score = realScore;
            } else {
                score = -realScore;
            }
        }
        return score;
    }


}

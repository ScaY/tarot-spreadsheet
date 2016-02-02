package fr.isen.m2.jee.tarotspreadsheet.core;

import fr.isen.m2.jee.tarotspreadsheet.model.Player;
import fr.isen.m2.jee.tarotspreadsheet.model.Score;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
/*
*
 * Created by renou on 01/02/16.
 */

public class RulesGameTest4Players {

    //Test 4 joueurs

    //TestRéférence
/*
    Partie à 4
    3 bouts
    Réussite sur Petite de 036 (+0)
    Aucun point supplémentaire
*/


    @Test
    public void success0PointTryPetite3Bout() throws Exception {
        int nbPlayer = 4;
        int takenPlayer = 1;
        int calledPlayer = -1;
        int nbBout = 3;
        int score = 36;
        int contrat = 0; //0 = Petite
        String petitAuBout = "none";
        int poignee = 0;
        String poignee_equipe = "none";
        String chelem_equipe = "none";
        String chelem_score = "none";


        List<Score> scoreList = RulesGame.newScore(nbPlayer, takenPlayer, calledPlayer, nbBout, score, contrat,
                petitAuBout, poignee, poignee_equipe, chelem_equipe, chelem_score);

        assertThat(scoreList.get(0).getPoint()).isEqualTo(0);
        assertThat(scoreList.get(1).getPoint()).isEqualTo(0);
        assertThat(scoreList.get(2).getPoint()).isEqualTo(0);
        assertThat(scoreList.get(3).getPoint()).isEqualTo(0);


    }
/*
Partie à 4
joueur 1 prend
3 bouts
Fail sur Petite de 35 (-1)
Aucun point supplémentaire

*/

    @Test
    public void failTryPetite3Bout() throws Exception {
        int nbPlayer = 4;
        int takenPlayer = 1;
        int calledPlayer = -1;
        int nbBout = 3;
        int score = 35;
        int contrat = 0; //0 = Petite
        String petitAuBout = "none";
        int poignee = 0;
        String poignee_equipe = "none";
        String chelem_equipe = "none";
        String chelem_score = "none";

        List<Score> scoreList = RulesGame.newScore(nbPlayer, takenPlayer, calledPlayer, nbBout, score, contrat,
                petitAuBout, poignee, poignee_equipe, chelem_equipe, chelem_score);

        assertThat(scoreList.get(0).getPoint()).isEqualTo(-3);
        assertThat(scoreList.get(1).getPoint()).isEqualTo(1);
        assertThat(scoreList.get(2).getPoint()).isEqualTo(1);
        assertThat(scoreList.get(3).getPoint()).isEqualTo(1);


    }
/*
    Partie à 4
    joueur 1 prend
    3 bouts
    Réussite sur Petite avec 46pts (+10)
    Aucun point supplémentaire

*/

    @Test
    public void success10PointsTryPetite3Bout() throws Exception {
        int nbPlayer = 4;
        int takenPlayer = 1;
        int calledPlayer = -1;
        int nbBout = 3;
        int score = 46;
        int contrat = 0; //0 = Petite
        String petitAuBout = "none";
        int poignee = 0;
        String poignee_equipe = "none";
        String chelem_equipe = "none";
        String chelem_score = "none";


        List<Score> scoreList = RulesGame.newScore(nbPlayer, takenPlayer, calledPlayer, nbBout, score, contrat,
                petitAuBout, poignee, poignee_equipe, chelem_equipe, chelem_score);

        assertThat(scoreList.get(0).getPoint()).isEqualTo(30);
        assertThat(scoreList.get(1).getPoint()).isEqualTo(-10);
        assertThat(scoreList.get(2).getPoint()).isEqualTo(-10);
        assertThat(scoreList.get(3).getPoint()).isEqualTo(-10);
    }
/*
    Partie à 4
    joueur 4 prend
    3 bouts
    Réussite sur Petite avec 46pts (+10)
    Aucun point supplémentaire
*/


    @Test
    public void successTryPetite3BoutByPlayer4() throws Exception {
        int nbPlayer = 4;
        int takenPlayer = 4;
        int calledPlayer = -1;
        int nbBout = 3;
        int score = 46;
        int contrat = 0; //0 = Petite
        String petitAuBout = "none";
        int poignee = 0;
        String poignee_equipe = "none";
        String chelem_equipe = "none";
        String chelem_score = "none";


        List<Score> scoreList = RulesGame.newScore(nbPlayer, takenPlayer, calledPlayer, nbBout, score, contrat,
                petitAuBout, poignee, poignee_equipe, chelem_equipe, chelem_score);

        assertThat(scoreList.get(0).getPoint()).isEqualTo(-10);
        assertThat(scoreList.get(1).getPoint()).isEqualTo(-10);
        assertThat(scoreList.get(2).getPoint()).isEqualTo(-10);
        assertThat(scoreList.get(3).getPoint()).isEqualTo(30);

    }


    //TestNbBout
/*
    Partie à 3
    joueur 1 prend
    0 bouts
    Réussite sur Petite avec 66pts (+10)
    Aucun point supplémentaire

*/


    @Test
    public void successTryPetite0Bout() throws Exception {
        int nbPlayer = 4;
        int takenPlayer = 1;
        int calledPlayer = -1;
        int nbBout = 0;
        int score = 66;
        int contrat = 0; //0 = Petite
        String petitAuBout = "none";
        int poignee = 0;
        String poignee_equipe = "none";
        String chelem_equipe = "none";
        String chelem_score = "none";


        List<Score> scoreList = RulesGame.newScore(nbPlayer, takenPlayer, calledPlayer, nbBout, score, contrat,
                petitAuBout, poignee, poignee_equipe, chelem_equipe, chelem_score);

        assertThat(scoreList.get(0).getPoint()).isEqualTo(30);
        assertThat(scoreList.get(1).getPoint()).isEqualTo(-10);
        assertThat(scoreList.get(2).getPoint()).isEqualTo(-10);
        assertThat(scoreList.get(3).getPoint()).isEqualTo(-10);
    }


    //TestContrat
/*
    Partie à 3
    joueur 1 prend
    3 bouts
    Réussite sur Garde avec 46pts (+10)
    Aucun point supplémentaire
*/


    @Test
    public void successTryGarde3Bout() throws Exception {
        int nbPlayer = 4;
        int takenPlayer = 1;
        int calledPlayer = -1;
        int nbBout = 3;
        int score = 46;
        int contrat = 1; //1 = Garde
        String petitAuBout = "none";
        int poignee = 0;
        String poignee_equipe = "none";
        String chelem_equipe = "none";
        String chelem_score = "none";


        List<Score> scoreList = RulesGame.newScore(nbPlayer, takenPlayer, calledPlayer, nbBout, score, contrat,
                petitAuBout, poignee, poignee_equipe, chelem_equipe, chelem_score);

        assertThat(scoreList.get(0).getPoint()).isEqualTo(60);
        assertThat(scoreList.get(1).getPoint()).isEqualTo(-20);
        assertThat(scoreList.get(2).getPoint()).isEqualTo(-20);
        assertThat(scoreList.get(3).getPoint()).isEqualTo(-20);
    }

/*
    Partie à 4
    joueur 1 prend
    3 bouts
    Réussite sur Petite avec 46pts (+10)
    Petit au bout pour l'attaque

*/

    @Test
    public void successTryWithPetitAtTheEnd() throws Exception {
        int nbPlayer = 4;
        int takenPlayer = 1;
        int calledPlayer = -1;
        int nbBout = 3;
        int score = 46;
        int contrat = 0; //0 = Petite
        String petitAuBout = "attaque";
        int poignee = 0;
        String poignee_equipe = "none";
        String chelem_equipe = "none";
        String chelem_score = "none";


        List<Score> scoreList = RulesGame.newScore(nbPlayer, takenPlayer, calledPlayer, nbBout, score, contrat,
                petitAuBout, poignee, poignee_equipe, chelem_equipe, chelem_score);

        assertThat(scoreList.get(0).getPoint()).isEqualTo(60);
        assertThat(scoreList.get(1).getPoint()).isEqualTo(-20);
        assertThat(scoreList.get(2).getPoint()).isEqualTo(-20);
        assertThat(scoreList.get(3).getPoint()).isEqualTo(-20);
    }


/*
    Partie à 4
    joueur 1 prend
    3 bouts
    Réussite sur Petite avec 46pts (+10)
    Simple poignée
*/


    @Test
    public void successTryWithPoignee() throws Exception {
        int nbPlayer = 4;
        int takenPlayer = 1;
        int calledPlayer = -1;
        int nbBout = 3;
        int score = 46;
        int contrat = 0; //0 = Petite
        String petitAuBout = "none";
        int poignee = 1;
        String poignee_equipe = "attaque";
        String chelem_equipe = "none";
        String chelem_score = "none";

        List<Score> scoreList = RulesGame.newScore(nbPlayer, takenPlayer, calledPlayer, nbBout, score, contrat,
                petitAuBout, poignee, poignee_equipe, chelem_equipe, chelem_score);

        assertThat(scoreList.get(0).getPoint()).isEqualTo(90);
        assertThat(scoreList.get(1).getPoint()).isEqualTo(-30);
        assertThat(scoreList.get(2).getPoint()).isEqualTo(-30);
        assertThat(scoreList.get(3).getPoint()).isEqualTo(-30);
    }

/*
    Partie à 4
    joueur 1 prend
    3 bouts
    Réussite sur Petite avec 46pts (+10)
    Chelem annoncé et réussi
*/


    @Test
    public void successTryWithChelem() throws Exception {
        int nbPlayer = 4;
        int takenPlayer = 1;
        int calledPlayer = -1;
        int nbBout = 3;
        int score = 46;
        int contrat = 0; //0 = Petite
        String petitAuBout = "none";
        int poignee = 0;
        String poignee_equipe = "none";
        String chelem_equipe = "attaque";
        String chelem_score = "CallAndDone";

        List<Score> scoreList = RulesGame.newScore(nbPlayer, takenPlayer, calledPlayer, nbBout, score, contrat,
                petitAuBout, poignee, poignee_equipe, chelem_equipe, chelem_score);

        assertThat(scoreList.get(0).getPoint()).isEqualTo(1230);
        assertThat(scoreList.get(1).getPoint()).isEqualTo(-410);
        assertThat(scoreList.get(2).getPoint()).isEqualTo(-410);
        assertThat(scoreList.get(3).getPoint()).isEqualTo(-410);
    }
/*
    Partie à 4
    joueur 1 prend
    3 bouts
    Réussite sur Petite avec 46pts (+10)
    Chelem Non annoncé et réussi
*/


    @Test
    public void successTryWithChelemnotCalled() throws Exception {
        int nbPlayer = 4;
        int takenPlayer = 1;
        int calledPlayer = -1;
        int nbBout = 3;
        int score = 46;
        int contrat = 0; //0 = Petite
        String petitAuBout = "none";
        int poignee = 0;
        String poignee_equipe = "none";
        String chelem_equipe = "attaque";
        String chelem_score = "notCallButDone";


        List<Score> scoreList = RulesGame.newScore(nbPlayer, takenPlayer, calledPlayer, nbBout, score, contrat,
                petitAuBout, poignee, poignee_equipe, chelem_equipe, chelem_score);

        assertThat(scoreList.get(0).getPoint()).isEqualTo(630);
        assertThat(scoreList.get(1).getPoint()).isEqualTo(-210);
        assertThat(scoreList.get(2).getPoint()).isEqualTo(-210);
        assertThat(scoreList.get(3).getPoint()).isEqualTo(-210);

    }
    /*
    Partie à 4
    joueur 1 prend
    3 bouts
    Réussite sur Petite avec 46pts (+10)
    Chelem annoncé et fail
*/


    @Test
    public void successTryWithFailChelem() throws Exception {
        int nbPlayer = 4;
        int takenPlayer = 1;
        int calledPlayer = -1;
        int nbBout = 3;
        int score = 46;
        int contrat = 0; //0 = Petite
        String petitAuBout = "none";
        int poignee = 0;
        String poignee_equipe = "none";
        String chelem_equipe = "attaque";
        String chelem_score = "callButNotDone";


        List<Score> scoreList = RulesGame.newScore(nbPlayer, takenPlayer, calledPlayer, nbBout, score, contrat,
                petitAuBout, poignee, poignee_equipe, chelem_equipe, chelem_score);

        assertThat(scoreList.get(0).getPoint()).isEqualTo(-570);
        assertThat(scoreList.get(1).getPoint()).isEqualTo(190);
        assertThat(scoreList.get(2).getPoint()).isEqualTo(190);
        assertThat(scoreList.get(3).getPoint()).isEqualTo(190);


    }
/*
    Partie à 4
    joueur 1 prend
    3 bouts
    Réussite sur Petite avec 46pts (+10)
    Chelem non annoncé mais réussi par la defense
*/


    @Test
    public void successTryWithFailDefenseChelem() throws Exception {
        int nbPlayer = 4;
        int takenPlayer = 1;
        int calledPlayer = -1;
        int nbBout = 3;
        int score = 46;
        int contrat = 0; //0 = Petite
        String petitAuBout = "none";
        int poignee = 0;
        String poignee_equipe = "none";
        String chelem_equipe = "defense";
        String chelem_score = "notCallButDone";


        List<Score> scoreList = RulesGame.newScore(nbPlayer, takenPlayer, calledPlayer, nbBout, score, contrat,
                petitAuBout, poignee, poignee_equipe, chelem_equipe, chelem_score);

        assertThat(scoreList.get(0).getPoint()).isEqualTo(-570);
        assertThat(scoreList.get(1).getPoint()).isEqualTo(190);
        assertThat(scoreList.get(2).getPoint()).isEqualTo(190);
        assertThat(scoreList.get(3).getPoint()).isEqualTo(190);
    }



}

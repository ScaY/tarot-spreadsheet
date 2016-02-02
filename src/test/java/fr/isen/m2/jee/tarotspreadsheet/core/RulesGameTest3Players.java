package fr.isen.m2.jee.tarotspreadsheet.core;

import fr.isen.m2.jee.tarotspreadsheet.model.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;


public class RulesGameTest3Players {

    private RulesGame game3Player;



    private Player p30 = new Player("1on3");
    private Player p31 = new Player("2on3");
    private Player p32 = new Player("3on3");




    @Before
    public void doBefore() {

        ArrayList<Player> playersGameAt3 = new ArrayList<Player>();
        playersGameAt3.add(p30);
        playersGameAt3.add(p31);
        playersGameAt3.add(p32);

        game3Player = new RulesGame(playersGameAt3);


    }

    //Test 3 joueurs

    //TestRéférence

    /*
    Partie à 3
    3 bouts
    Réussite sur Petite de 036 (+0)
    Aucun point supplémentaire

     */
    @Test
    public void success0PointTryPetite3Bout() throws Exception {
        int nbPlayer = 3;
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



        game3Player.newScore(nbPlayer,takenPlayer,calledPlayer,nbBout,score,contrat,petitAuBout,poignee,poignee_equipe,chelem_equipe,chelem_score);

        assertThat(p30.getLastScore().getPoint()).isEqualTo(0);
        assertThat(p31.getLastScore().getPoint()).isEqualTo(0);
        assertThat(p32.getLastScore().getPoint()).isEqualTo(0);

    }

    /*
Partie à 3
joueur 1 prend
3 bouts
Fail sur Petite de 35 (-1)
Aucun point supplémentaire

 */
    @Test
    public void failTryPetite3Bout() throws Exception {
        int nbPlayer = 3;
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

        game3Player.newScore(nbPlayer, takenPlayer, calledPlayer, nbBout, score, contrat, petitAuBout, poignee, poignee_equipe, chelem_equipe, chelem_score);

        assertThat(p30.getLastScore().getPoint()).isEqualTo(-2);
        assertThat(p31.getLastScore().getPoint()).isEqualTo(1);
        assertThat(p32.getLastScore().getPoint()).isEqualTo(1);

    }

    /*
    Partie à 3
    joueur 1 prend
    3 bouts
    Réussite sur Petite avec 46pts (+10)
    Aucun point supplémentaire
    */

    @Test
    public void success10PointsTryPetite3Bout() throws Exception {
        int nbPlayer = 3;
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


        game3Player.newScore(nbPlayer,takenPlayer,calledPlayer,nbBout,score,contrat,petitAuBout,poignee,poignee_equipe,chelem_equipe,chelem_score);

        assertThat(p30.getLastScore().getPoint()).isEqualTo(20);
        assertThat(p31.getLastScore().getPoint()).isEqualTo(-10);
        assertThat(p32.getLastScore().getPoint()).isEqualTo(-10);

    }

    /*
    Partie à 3
    joueur 3 prend
    3 bouts
    Réussite sur Petite avec 46pts (+10)
    Aucun point supplémentaire
    */

    @Test
    public void successTryPetite3BoutByPlayer3() throws Exception {
        int nbPlayer = 3;
        int takenPlayer = 3;
        int calledPlayer = -1;
        int nbBout = 3;
        int score = 46;
        int contrat = 0; //0 = Petite
        String petitAuBout = "none";
        int poignee = 0;
        String poignee_equipe = "none";
        String chelem_equipe = "none";
        String chelem_score = "none";


        game3Player.newScore(nbPlayer,takenPlayer,calledPlayer,nbBout,score,contrat,petitAuBout,poignee,poignee_equipe,chelem_equipe,chelem_score);

        assertThat(p30.getLastScore().getPoint()).isEqualTo(-10);
        assertThat(p31.getLastScore().getPoint()).isEqualTo(-10);
        assertThat(p32.getLastScore().getPoint()).isEqualTo(20);

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
       int nbPlayer = 3;
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


       game3Player.newScore(nbPlayer,takenPlayer,calledPlayer,nbBout,score,contrat,petitAuBout,poignee,poignee_equipe,chelem_equipe,chelem_score);

       assertThat(p30.getLastScore().getPoint()).isEqualTo(20);
       assertThat(p31.getLastScore().getPoint()).isEqualTo(-10);
       assertThat(p32.getLastScore().getPoint()).isEqualTo(-10);
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
        int nbPlayer = 3;
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


        game3Player.newScore(nbPlayer,takenPlayer,calledPlayer,nbBout,score,contrat,petitAuBout,poignee,poignee_equipe,chelem_equipe,chelem_score);

        assertThat(p30.getLastScore().getPoint()).isEqualTo(40);
        assertThat(p31.getLastScore().getPoint()).isEqualTo(-20);
        assertThat(p32.getLastScore().getPoint()).isEqualTo(-20);
    }


    /*
    Partie à 3
    joueur 1 prend
    3 bouts
    Réussite sur Petite avec 46pts (+10)
    Petit au bout pour l'attaque
    */

    @Test
    public void successTryWithPetitAtTheEnd() throws Exception {
        int nbPlayer = 3;
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


        game3Player.newScore(nbPlayer,takenPlayer,calledPlayer,nbBout,score,contrat,petitAuBout,poignee,poignee_equipe,chelem_equipe,chelem_score);

        assertThat(p30.getLastScore().getPoint()).isEqualTo(40);
        assertThat(p31.getLastScore().getPoint()).isEqualTo(-20);
        assertThat(p32.getLastScore().getPoint()).isEqualTo(-20);
    }



    /*
    Partie à 3
    joueur 1 prend
    3 bouts
    Réussite sur Petite avec 46pts (+10)
    Simple poignée
    */

    @Test
    public void successTryWithPoignee() throws Exception {
        int nbPlayer = 3;
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

        game3Player.newScore(nbPlayer,takenPlayer,calledPlayer,nbBout,score,contrat,petitAuBout,poignee,poignee_equipe,chelem_equipe,chelem_score);

        assertThat(p30.getLastScore().getPoint()).isEqualTo(60);
        assertThat(p31.getLastScore().getPoint()).isEqualTo(-30);
        assertThat(p32.getLastScore().getPoint()).isEqualTo(-30);
    }


    /*
    Partie à 3
    joueur 1 prend
    3 bouts
    Réussite sur Petite avec 46pts (+10)
    Chelem annoncé et réussi
    */

    @Test
    public void successTryWithChelem() throws Exception {
        int nbPlayer = 3;
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

        game3Player.newScore(nbPlayer,takenPlayer,calledPlayer,nbBout,score,contrat,petitAuBout,poignee,poignee_equipe,chelem_equipe,chelem_score);


        assertThat(p30.getLastScore().getPoint()).isEqualTo(820);
        assertThat(p31.getLastScore().getPoint()).isEqualTo(-410);
        assertThat(p32.getLastScore().getPoint()).isEqualTo(-410);

    }

        /*
    Partie à 3
    joueur 1 prend
    3 bouts
    Réussite sur Petite avec 46pts (+10)
    Chelem Non annoncé et réussi
    */

    @Test
    public void successTryWithChelemnotCalled() throws Exception {
        int nbPlayer = 3;
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


        game3Player.newScore(nbPlayer,takenPlayer,calledPlayer,nbBout,score,contrat,petitAuBout,poignee,poignee_equipe,chelem_equipe,chelem_score);

        assertThat(p30.getLastScore().getPoint()).isEqualTo(420);
        assertThat(p31.getLastScore().getPoint()).isEqualTo(-210);
        assertThat(p32.getLastScore().getPoint()).isEqualTo(-210);

    }
    /*
    Partie à 3
    joueur 1 prend
    3 bouts
    Réussite sur Petite avec 46pts (+10)
    Chelem annoncé et fail
    */

    @Test
    public void successTryWithFailChelem() throws Exception {
        int nbPlayer = 3;
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


        game3Player.newScore(nbPlayer,takenPlayer,calledPlayer,nbBout,score,contrat,petitAuBout,poignee,poignee_equipe,chelem_equipe,chelem_score);

        assertThat(p30.getLastScore().getPoint()).isEqualTo(-380);
        assertThat(p31.getLastScore().getPoint()).isEqualTo(190);
        assertThat(p32.getLastScore().getPoint()).isEqualTo(190);

    }

     /*
    Partie à 3
    joueur 1 prend
    3 bouts
    Réussite sur Petite avec 46pts (+10)
    Chelem non annoncé mais réussi par la defense
    */

    @Test
    public void successTryWithFailDefenseChelem() throws Exception {
        int nbPlayer = 3;
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


        game3Player.newScore(nbPlayer,takenPlayer,calledPlayer,nbBout,score,contrat,petitAuBout,poignee,poignee_equipe,chelem_equipe,chelem_score);

        assertThat(p30.getLastScore().getPoint()).isEqualTo(-380);
        assertThat(p31.getLastScore().getPoint()).isEqualTo(190);
        assertThat(p32.getLastScore().getPoint()).isEqualTo(190);

    }



}

package fr.isen.m2.jee.tarotspreadsheet.model;


import fr.isen.m2.jee.tarotspreadsheet.model.Player;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;


public class ScoreTest {

    private Player p;

    @Before
    public void doBefore() {
        Player p = new Player("p");
    }


    @Test
    public void newScoreDefaultControllerTest() throws Exception
    {
        Score newScore = new Score();

        assertThat(newScore.getPoint()).isEqualTo(0);

    }

    @Test
    public void newScorePointControllerTest() throws Exception
    {
        Score newScore = new Score(10);

        assertThat(newScore.getPoint()).isEqualTo(10);

    }

    @Test
    public void newScoreFullControllerTest() throws Exception
    {
        Score newScore = new Score(10,true,false,true,p);

        assertThat(newScore.getPoint()).isEqualTo(10);
        assertThat(newScore.getPlayer()).isEqualTo(p);


    }





}

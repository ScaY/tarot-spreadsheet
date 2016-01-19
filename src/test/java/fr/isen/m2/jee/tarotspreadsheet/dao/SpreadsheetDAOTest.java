package fr.isen.m2.jee.tarotspreadsheet.dao;

import fr.isen.m2.jee.tarotspreadsheet.dao.guice.GuiceRunner;
import fr.isen.m2.jee.tarotspreadsheet.dao.guice.H2DBModule;
import fr.isen.m2.jee.tarotspreadsheet.dao.guice.Modules;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(GuiceRunner.class)
@Modules({H2DBModule.class, JPAModule.class})
public class SpreadsheetDAOTest {

    @Inject
    EntityManager em;

    @Inject
    SpreadsheetDAO dao;

    @Test
    public void daoIsInjected() throws Exception {
        assertThat(dao).isNotNull();
    }

    @Test
    public void itCanCreateASpreadsheet() throws Exception {
        String name = "nameTest", tokenTest = "tokenTest";
        int nbPlayer = 5;
        SpreadsheetAdapter spreadsheet = dao.createNewSpreadsheet(name, nbPlayer, tokenTest);
        assertThat(spreadsheet).isNotNull();

        String token = spreadsheet.getToken();
        assertThat(spreadsheet.getToken()).isNotNull();
        em.clear();
        spreadsheet = dao.loadFromToken(token);
        assertThat(spreadsheet).isNotNull();
        assertThat(spreadsheet.getName()).isEqualTo(name);
        assertThat(spreadsheet.getToken()).isEqualTo(token);
        assertThat(spreadsheet.getNbPlayer()).isEqualTo(nbPlayer);
    }
}

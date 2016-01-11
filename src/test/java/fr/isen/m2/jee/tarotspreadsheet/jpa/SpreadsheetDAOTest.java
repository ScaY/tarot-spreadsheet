
package fr.isen.m2.jee.tarotspreadsheet.jpa;

import fr.isen.m2.jee.tarotspreadsheet.jpa.guice.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(GuiceRunner.class)
@Modules({JpaDaoModule.class, H2DBModule.class})
public class SpreadsheetDAOTest {

    @Inject
    JPASpreadsheetDAO dao;

    @Test
    public void iCanCreateAndRetrieveASpreadsheet() throws Exception {

        String token = "token", name = "name";
        int nbPlayer = 1;
        // On crée un billet de blog
        Spreadsheet entry = dao.createEntry(nbPlayer, token, name);
        checkSpreadsheet(entry, nbPlayer, token, name);

        // On le sauvegarde
        dao.saveEntry(entry);
        assertNotNull(entry.getId());
        Long id = entry.getId();

        // On le récupère
        entry = dao.getSpreadsheetByTitle(name).get(0);
        checkSpreadsheet(entry, nbPlayer, token, name);

    }

    private void checkSpreadsheet(Spreadsheet entry, int nbPlayer, String token, String name) {
        assertThat(entry.getName()).isEqualTo(name);
        assertThat(entry.getToken()).isEqualTo(token);
        assertThat(entry.getNbPlayer()).isEqualTo(nbPlayer);
    }
}

package fr.isen.m2.jee.tarotspreadsheet.jpa.guice;

import fr.isen.m2.jee.tarotspreadsheet.jpa.Spreadsheet;
import fr.isen.m2.jee.tarotspreadsheet.jpa.SpreadsheetDAO;
import fr.isen.m2.jee.tarotspreadsheet.jpa.SpreadsheetImpl;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class JPASpreadsheetDAO implements SpreadsheetDAO{

    @Inject
    EntityManager em;

    public Spreadsheet createEntry(int nbPlayer, String token, String name) {
        return new SpreadsheetImpl(nbPlayer, token, name);
    }

    public void saveEntry(Spreadsheet entry) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(entry);
        tx.commit();
    }

    public List<Spreadsheet> getSpreadsheetByTitle(String name) {
        return em.createNamedQuery(SpreadsheetImpl.ENTRIES_BY_NAME).setParameter("name", name).getResultList();
    }

    public List<Spreadsheet> getSpreadsheet() {
        List<Spreadsheet> resultList = em.createNamedQuery(
                SpreadsheetImpl.ALL_ENTRIES).getResultList();
        return resultList;
    }
}

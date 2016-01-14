package fr.isen.m2.jee.tarotspreadsheet.dao;

import fr.isen.m2.jee.tarotspreadsheet.model.Spreadsheet;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.inject.Inject;
import java.util.List;


@Singleton
@Lock(LockType.READ)
public class SpreadsheetDAO {

    @Inject
    private DAO dao;

    public Spreadsheet create(String name, String token, int nbPlayer) {
        Spreadsheet spreadsheet = new Spreadsheet();
        spreadsheet.setName(name);
        spreadsheet.setToken(token);
        spreadsheet.setNbPlayer(nbPlayer);
        return dao.create(spreadsheet);
    }

    public Spreadsheet find(long id) {
        return dao.find(Spreadsheet.class, id);
    }

    public List<Spreadsheet> list(int first, int max) {
        return dao.namedFind(Spreadsheet.class, Spreadsheet.LIST, first, max);
    }

    public void delete(long id) {
        dao.delete(Spreadsheet.class, id);
    }

    public Spreadsheet update(long id, String name, String token, int nbPlayer) {
        Spreadsheet spreadsheet = dao.find(Spreadsheet.class, id);
        if (spreadsheet == null) {
            throw new IllegalArgumentException("spreadhseet id " + id + " not found");
        }
        spreadsheet.setName(name);
        spreadsheet.setToken(token);
        spreadsheet.setNbPlayer(nbPlayer);
        return dao.update(spreadsheet);
    }
}

package fr.isen.m2.jee.tarotspreadsheet.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("spreadsheet")
@RequestScoped
public class SpreadsheetBean implements Serializable {

    private String name;
    private int nbPlayer;

    public SpreadsheetBean() {
        this(null, -1);
    }

    public SpreadsheetBean(String name, int nbPlayer) {
        this.name = name;
        this.nbPlayer = nbPlayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNbPlayer() {
        return nbPlayer;
    }

    public void setNbPlayer(int nbPlayer) {
        this.nbPlayer = nbPlayer;
    }
}

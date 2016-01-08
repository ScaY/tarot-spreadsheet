package fr.isen.m2.jee.tarotspreadsheet;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named("spreadsheet")
@RequestScoped
public class Spreadsheet implements Serializable {

    private String name;
    private int nbPlayer;

    public Spreadsheet() {
        this(null, -1);
    }

    public Spreadsheet(String name, int nbPlayer) {
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

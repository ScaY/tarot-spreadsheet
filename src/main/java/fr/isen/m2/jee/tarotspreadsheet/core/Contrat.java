package fr.isen.m2.jee.tarotspreadsheet.core;

/**
 * Created by renou on 14/01/16.
 */

public enum Contrat {
    PETITE(1),
    GARDE(2),
    GARDESANS(4),
    GARDECONTRE(6);

    private final int value;

    Contrat(int value){
        this.value = value;
    }

    public int getValue(){return this.value;}

}

package fr.isen.m2.jee.tarotspreadsheet.core;

/**
 * Created by renou on 14/01/16.
 */
public enum Bout {
    GOT0(56),
    GOT1(51),
    GOT2(41),
    GOT3(31);

    private final int value;

    Bout(int value){
        this.value = value;
    }

    public int getValue(){return this.value;}
}

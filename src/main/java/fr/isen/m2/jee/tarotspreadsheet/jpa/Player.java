package fr.isen.m2.jee.tarotspreadsheet.jpa;

public interface Player {

    Long getId();

    String getName();

    Spreadsheet getSpreadsheet();
}

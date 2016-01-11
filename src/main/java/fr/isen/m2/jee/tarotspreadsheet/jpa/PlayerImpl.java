package fr.isen.m2.jee.tarotspreadsheet.jpa;


import javax.persistence.*;

@Entity(name = "player")
public class PlayerImpl implements Player {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    private String name;

    @ManyToOne
    private SpreadsheetImpl spreadsheet;

    public PlayerImpl() {
        this(null, null);
    }

    public PlayerImpl(SpreadsheetImpl spreadsheet, String name) {
        this.spreadsheet = spreadsheet;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public SpreadsheetImpl getSpreadsheet() {
        return spreadsheet;
    }

}

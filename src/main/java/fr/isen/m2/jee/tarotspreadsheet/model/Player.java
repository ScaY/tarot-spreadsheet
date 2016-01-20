package fr.isen.m2.jee.tarotspreadsheet.model;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

@Entity
public class Player {

    public static final String NAME = "name";
    public static final String ID = "id";
    public static final String SPREADSHEET = "spreadsheet";
    public static final String SCORES = "scores";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @ManyToOne
    private Spreadsheet spreadsheet;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    @OrderColumn(name = "index")
    private List<Score> scores = new ArrayList<Score>();

    public Player() {
        this(null, null);
    }

    public Player(String name, Spreadsheet spreadsheet) {
        this.name = name;
        this.spreadsheet = spreadsheet;
        this.scores = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Spreadsheet getSpreadsheet() {
        return spreadsheet;
    }

    public void setSpreadsheet(Spreadsheet spreadsheet) {
        this.spreadsheet = spreadsheet;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public Score getLastScore() {
        return this.scores.get(this.scores.size() - 1);
    }

    public void addScore(int point, boolean isTaken, boolean isCalled, boolean isSuccess) {
        this.scores.add(new Score(point, isTaken, isCalled, isSuccess));
    }
}

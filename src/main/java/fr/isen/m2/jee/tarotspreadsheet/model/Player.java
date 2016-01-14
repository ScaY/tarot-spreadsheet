package fr.isen.m2.jee.tarotspreadsheet.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "player.list", query = "select p from Player p")
})
@XmlRootElement(name = "player")
public class Player extends Model {

    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "spreadsheet_id")
    @Valid
    @XmlTransient
    private Spreadsheet spreadsheet;

    @OneToMany(mappedBy = "player", fetch = FetchType.EAGER)
    private List<Score> scores = new ArrayList<Score>();

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
}

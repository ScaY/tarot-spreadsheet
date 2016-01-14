package fr.isen.m2.jee.tarotspreadsheet.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@NamedQueries({
        @NamedQuery(name = Score.LIST, query = "select p from Score p")
})
@XmlRootElement(name = "score")
public class Score extends Model {

    public static final String LIST = "score.list";

    @NotNull
    private int point;

    @NotNull
    private boolean isCalled;

    @NotNull
    private boolean isTaken;

    @ManyToOne
    @JoinColumn(name = "player_id")
    @Valid
    @XmlTransient
    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public boolean isCalled() {
        return isCalled;
    }

    public void setCalled(boolean called) {
        isCalled = called;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}

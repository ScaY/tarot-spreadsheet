package fr.isen.m2.jee.tarotspreadsheet.model;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Score {

    public static final String POINT = "point";
    public static final String ID = "id";
    public static final String CALLED = "called";
    public static final String TAKEN = "taken";
    public static final String SUCCESS = "success";
    public static final String PLAYER = "player";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private int point;

    @NotNull
    private boolean isCalled;

    @NotNull
    private boolean isTaken;

    @ManyToOne
    private Player player;

    @NotNull
    private boolean isSuccess;

    public Score() {
        this(0);
    }

    public Score(int point) {
        this(point, false, false, false);
    }

    public Score(int point, boolean isTaken, boolean isCalled, boolean isSuccess) {
        this.point = point;
        this.isTaken = isTaken;
        this.isCalled = isCalled;
        this.isSuccess = isSuccess;
    }

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

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public Long getId() {
        return id;
    }
}

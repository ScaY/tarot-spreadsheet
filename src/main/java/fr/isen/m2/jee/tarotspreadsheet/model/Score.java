package fr.isen.m2.jee.tarotspreadsheet.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
        this(point, false, false, false, null);
    }

    public Score(int point, boolean isTaken, boolean isCalled, boolean isSuccess, Player player) {
        this.point = point;
        this.isTaken = isTaken;
        this.isCalled = isCalled;
        this.isSuccess = isSuccess;
        this.player = player;
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

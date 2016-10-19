/*
 * Copyright 2014 Andrej Badinka
 */

package sk.badand.mafuti.model.match;

/**
 *
 * @author abadinka
 */
public class TeamMatchStats {
    
    private short shotsBlocked = 0;
    private short shotsOnTarget = 0;
    private short shotsOffTarget = 0;
    private short goals = 0;
    private short fouls = 0;
    private short yellowCards = 0;
    private short redCards = 0;
    private short freeKicks = 0;
    private short corners = 0;
    private short offsides = 0;
    private byte possesion = 0;

    //hidden attributes
    private short lostBalls = 0;
    private short missedPasses = 0;
    private short successfulPasses = 0;
    private short missedFreekicks = 0;
    private short successfulFreekicks = 0;
    private short missedCorners = 0;
    private short successfulCorners = 0;

    public TeamMatchStats() {
    }

    public void addShotsOnTarget(short shotsOnTarget) {
        this.shotsOnTarget += shotsOnTarget;
    }

    public void addShotsBlocked(short shotsBlocked) {
        this.shotsBlocked += shotsBlocked;
    }

    public void addShotsOffTarget(short shotsOffTarget) {
        this.shotsOffTarget += shotsOffTarget;
    }

    public void addGoals(short goals) {
        this.goals += goals;
    }

    public void addFouls(short fouls) {
        this.fouls += fouls;
    }

    public void addYellowCards(short yellowCards) {
        this.yellowCards += yellowCards;
    }

    public void addRedCards(short redCards) {
        this.redCards += redCards;
    }

    public void addFreeKicks(short freeKicks) {
        this.freeKicks += freeKicks;
    }

    public void addCorners(short corners) {
        this.corners += corners;
    }

    public void addOffsides(short offsides) {
        this.offsides += offsides;
    }

    public void addLostBalls(short lostBalls) {
        this.lostBalls += lostBalls;
    }

    public void addMissedPasses(short missedPasses) {
        this.missedPasses += missedPasses;
    }

    public void addSuccessfulPasses(short successfulPasses) {
        this.successfulPasses += successfulPasses;
    }

    public void addMissedFreekicks(short missedFreekicks) {
        this.missedFreekicks += missedFreekicks;
    }

    public void addSuccessfulFreekicks(short successfulFreekicks) {
        this.successfulFreekicks += successfulFreekicks;
    }

    public void addMissedCorners(short missedCorners) {
        this.missedCorners += missedCorners;
    }

    public void addSuccessfulCorners(short successfulCorners) {
        this.successfulCorners += successfulCorners;
    }

    public short getGoals() {
        return goals;
    }

    public short getShotsBlocked() {
        return shotsBlocked;
    }

    public short getShotsOnTarget() {
        return shotsOnTarget;
    }

    public short getShotsOffTarget() {
        return shotsOffTarget;
    }

    public short getFouls() {
        return fouls;
    }

    public short getFreeKicks() {
        return freeKicks;
    }

    public short getCorners() {
        return corners;
    }
}

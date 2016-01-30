/*
 * Copyright 2014 Andrej Badinka
 */

package sk.badand.mafuti.match.engine.builders;

/**
 *
 * @author abadinka
 */
public class MatchStats {
    
    private int shotsBlocked = 0;
    private int shotsOnTarget = 0;
    private int shotsOffTarget = 0;
    private int goals = 0;
    private int fouls = 0;
    private int yellowCards = 0;
    private int redCards = 0;
    private int freeKicks = 0;
    private int corners = 0;
    private int offsides = 0;
    
    //hidden attributes
    private int lostBalls = 0;
    private int missedPasses = 0;
    private int successfulPasses = 0;
    private int missedFreekicks = 0;
    private int successfulFreekicks = 0;
    private int missedCorners = 0;
    private int successfulCorners = 0;

    public MatchStats() {
    }

    public void addShotsOnTarget(int shotsOnTarget) {
        this.shotsOnTarget += shotsOnTarget;
    }

    public void addShotsBlocked(int shotsBlocked) {
        this.shotsBlocked += shotsBlocked;
    }

    public void addShotsOffTarget(int shotsOffTarget) {
        this.shotsOffTarget += shotsOffTarget;
    }

    public void addGoals(int goals) {
        this.goals += goals;
    }

    public void addFouls(int fouls) {
        this.fouls += fouls;
    }

    public void addYellowCards(int yellowCards) {
        this.yellowCards += yellowCards;
    }

    public void addRedCards(int redCards) {
        this.redCards += redCards;
    }

    public void addFreeKicks(int freeKicks) {
        this.freeKicks += freeKicks;
    }

    public void addCorners(int corners) {
        this.corners += corners;
    }

    public void addOffsides(int offsides) {
        this.offsides += offsides;
    }

    public void addLostBalls(int lostBalls) {
        this.lostBalls += lostBalls;
    }

    public void addMissedPasses(int missedPasses) {
        this.missedPasses += missedPasses;
    }

    public void addSuccessfulPasses(int successfulPasses) {
        this.successfulPasses += successfulPasses;
    }

    public void addMissedFreekicks(int missedFreekicks) {
        this.missedFreekicks += missedFreekicks;
    }

    public void addSuccessfulFreekicks(int successfulFreekicks) {
        this.successfulFreekicks += successfulFreekicks;
    }

    public void addMissedCorners(int missedCorners) {
        this.missedCorners += missedCorners;
    }

    public void addSuccessfulCorners(int successfulCorners) {
        this.successfulCorners += successfulCorners;
    }
    
}

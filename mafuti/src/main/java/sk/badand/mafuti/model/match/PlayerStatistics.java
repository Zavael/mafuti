/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.model.match;

import java.io.Serializable;

/**
 * @author abadinka
 */
public class PlayerStatistics implements Serializable {
    private static final long serialVersionUID = -7875415488593283026L;
    private final Player player;
    private final Match match;
    private short goalsScored;
    private short matchRating = 7;
    private short assits;

    public PlayerStatistics(Player player, Match match, short goalsScored, short assits) {
        this.player = player;
        this.match = match;
        this.goalsScored = goalsScored; //TODO affect matchrating
        this.assits = assits;
    }

    public PlayerStatistics withResult(short playerTeamGoals, short oponentGoals) {
        matchRating += playerTeamGoals > oponentGoals
                ? Math.round(2 * (playerTeamGoals / (double) (playerTeamGoals + oponentGoals)))
                : -Math.round(2 * (oponentGoals / (double) (playerTeamGoals + oponentGoals)));
        return this;
    }

    public void addGoalsScored(short goals) {
        this.goalsScored += goals;
    }

    public void addAssists(short assits) {
        this.assits += assits;
    }

    public short matchRating() {
        return (short) (matchRating + goalsScored + assits);
    }


    @Override
    public String toString() {

        return player.lastName()
                + ", g:"
                + goalsScored
                + ", a:"
                + assits
                + ", mr:"
                + matchRating();
    }

    public Player player() {
        return player;
    }
}

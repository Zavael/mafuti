/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.model.match;

import sk.badand.mafuti.model.common.Person;
import sk.badand.math.OddsDecider;

/**
 *
 * @author abadinka
 */
public interface Player extends Person {

    OddsDecider oddsDecider = new OddsDecider();

    int overallRating();

    boolean isPlaying();

    String positionAbbr();

    public boolean isPlayingOnPosition(PlayerPosition position);

    default public double scoreProbability() {
        if (isPlaying()) {
            return getCurrentPosition().getScoringProbability();
        }
        return 0;
    }

    default public double assistProbability() {
        if (isPlaying()) {
            return getCurrentPosition().getAssistProbability();
        }
        return 0;
    }

    PlayerPosition getCurrentPosition();
}

/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.model.match;

import sk.badand.mafuti.model.common.Person;
import sk.badand.mafuti.model.player.Injurable;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author abadinka
 */
public interface Player extends Person, Injurable {

    /**
     * Overall rating calculated from skills (for best position?)
     *
     * @return
     */
    int getOverallRating();

    int getPositionalRating(PlayerPosition position);

    boolean isPlaying();

    String getPositionAbbr();

    boolean isPlayingOnPosition(PlayerPosition position);

    default double scoreProbability() {
        if (isPlaying()) {
            return getCurrentPosition().getScoringProbability();
        }
        return 0;
    }

    default double assistProbability() {
        if (isPlaying()) {
            return getCurrentPosition().getAssistProbability();
        }
        return 0;
    }

    default int getAge(){
        return Period.between(getBirthDate(), LocalDate.now()).getYears();
    }

    PlayerPosition getCurrentPosition();

    @Override
    default int getEstimateValue() {
        return getOverallRating() * 10000; //TODO recalculate with age, potential?, morale, form, etc
    }
}

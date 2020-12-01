/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.model.match;

import java.io.Serializable;

/**
 *
 * @author abadinka
 */
public enum PlayerPosition implements Serializable {
    STRIKER("player.pos.st", "ST", 0.5, 0.3),
    WINGER("player.pos.wg", "WG", 0.4, 0.5),
    MIDFIELDER("player.pos.cm", "CM", 0.4, 0.4),
    WINGBACK("player.pos.sd", "SD", 0.2, 0.4),
    DEFENDER("player.pos.cd", "CD", 0.2, 0.3),
    GOALKEEPER("player.pos.gk", "GK", 0.005, 0.05);
    
    public final String key;
    public final String abbreviation;
    private final double scoringProbability;
    private final double assistProbability;
    
    PlayerPosition(String key, String abbreviation, double scoringProbability, double assistProbability) {
        this.key = key;
        this.abbreviation = abbreviation;
        this.scoringProbability = scoringProbability;
        this.assistProbability = assistProbability;
    }

    @Override
    public String toString() {
        return abbreviation;
    }

    public double getScoringProbability() {
        return scoringProbability;
    }

    public double getAssistProbability() {
        return assistProbability;
    }
}

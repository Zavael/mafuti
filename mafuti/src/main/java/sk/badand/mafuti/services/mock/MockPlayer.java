/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.services.mock;

import sk.badand.mafuti.services.Player;
import sk.badand.math.Randomizer;
import sk.badand.text.StrGenerator;

public class MockPlayer implements Player {

    @Override
    public boolean isPlaying() {
        return true;
    }

    @Override
    public int getOverallRating() {
        return rat;
    }
    private final int rat = new Randomizer().nextRandomInt(100, 500);

    @Override
    public String toString() {
        final StrGenerator strGenerator = new StrGenerator();
        return strGenerator.generateDesignation(5) + " " + strGenerator.generateDesignation(5)
                + ", skill:"
                + getOverallRating();
    }
}

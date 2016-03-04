/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.services.mock;

import sk.badand.mafuti.services.PlayableStadium;
import sk.badand.mafuti.services.PlayableTeam;
import sk.badand.mafuti.services.Result;
import sk.badand.math.Randomizer;


public class MockResult implements Result {
    
    private final PlayableTeam homeTeam;
    private final PlayableTeam awayTeam;
    private final PlayableStadium stadium;
    private final Randomizer randomizer = new Randomizer();

    public MockResult(PlayableTeam homeTeam, PlayableTeam awayTeam, PlayableStadium stadium) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.stadium = stadium;
    }

    @Override
    public String getAwayTeamName() {
        return awayTeam.getNameShort();
    }

    @Override
    public String getHomeTeamName() {
        return homeTeam.getNameShort();
    }    

    @Override
    public int homeShots() {
        return randomizer.nextRandomInt(20);
    }

    @Override
    public int awayShots() {
        return randomizer.nextRandomInt(20);
    }

    @Override
    public int homeCorners() {
        return randomizer.nextRandomInt(20);
    }

    @Override
    public int awayCorners() {
        return randomizer.nextRandomInt(20);
    }

    @Override
    public int homeFreekicks() {
        return randomizer.nextRandomInt(20);
    }

    @Override
    public int awayFreekicks() {
        return randomizer.nextRandomInt(20);
    }

    @Override
    public int homeFouls() {
        return randomizer.nextRandomInt(20);
    }

    @Override
    public int awayFouls() {
        return randomizer.nextRandomInt(20);
    }
}

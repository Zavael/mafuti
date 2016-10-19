/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.match.engine;

import sk.badand.mafuti.model.match.*;

import java.time.LocalDate;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

import sk.badand.mafuti.model.common.Weather;
import sk.badand.mafuti.model.match.result.Result;
import sk.badand.math.Randomizer;

/**
 * @author abadinka
 */
public class SimpleMatchEngine implements MatchEngine {

    private static final Logger LOG = Logger.getLogger(SimpleMatchEngine.class.getName());
    private static final Randomizer randomizer = new Randomizer();

    private final PlayingTeam homeTeam;
    private final PlayingTeam awayTeam;
    private Weather weather;
    private LocalDate playDate;
    private PlayableStadium stadium;
    private Result result;

    public SimpleMatchEngine(PlayingTeam homeTeam, PlayingTeam awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    @Override
    public MatchEngine inWeather(Weather weather) {
        this.weather = weather;
        return this;
    }

    @Override
    public MatchEngine atDate(LocalDate date) {
        this.playDate = date;
        return this;
    }

    @Override
    public MatchEngine atStadium(PlayableStadium stadium) {
        this.stadium = stadium;
        return this;
    }

    @Override
    public MatchEngine withObservers(ObservableEvents events, Observer... observers) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void play(Match match) {
        double ratio = awayTeam.strengthOveral() / (double) homeTeam.strengthOveral();
        final short homeGoals = (short) randomizer.nextRandomInt((int) (5 / ratio));
        final short awayGoals = (short) randomizer.nextRandomInt((int) (5 * ratio));

        TeamMatchStats homeTeamMatchStats = new TeamMatchStats();
        homeTeamMatchStats.addGoals(homeGoals);
        TeamMatchStats awayTeamMatchStats = new TeamMatchStats();
        awayTeamMatchStats.addGoals(awayGoals);
        this.result = new SimpleResult(match, homeTeam, awayTeam, playDate, stadium, homeTeamMatchStats, awayTeamMatchStats);
    }

    @Override
    public Result result() {
        return result;
    }

    public static void main(String[] args) {
        LOG.log(Level.WARNING, "start");
        Randomizer randomizer = new Randomizer();
        final int count = 10000;

        int hs = 180;
        int as = 450;

        double ratio = as / (double) hs;
        System.out.println("ratio: " + ratio);

        int hgs = 0, ags = 0;
        int win = 0, draw = 0, loss = 0;

        for (int i = 0; i < count; i++) {
            final int hg = randomizer.nextRandomInt((int) (5 / ratio));
            final int ag = randomizer.nextRandomInt((int) (5 * ratio));
            hgs += hg;
            ags += ag;
            int k = hg > ag ? win++ : hg == ag ? draw++ : loss++;
        }
        System.out.println("======================");
        System.out.println("avg result: " + (hgs / count) + " - " + (ags / count));
        System.out.println("goals: " + hgs + "-" + ags);
        System.out.println("home wins: " + win);
        System.out.println("draws: " + draw);
        System.out.println("away wins: " + loss);
    }
}

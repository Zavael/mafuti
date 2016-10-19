/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.services.mock;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import sk.badand.mafuti.model.match.PlayingTeam;
import sk.badand.mafuti.match.engine.SimpleMatchEngine;
import sk.badand.mafuti.model.common.Weather;
import sk.badand.mafuti.model.match.MatchEngine;
import sk.badand.mafuti.model.match.Player;
import sk.badand.mafuti.model.match.PlayableStadium;
import sk.badand.mafuti.model.match.PlayableMatch;
import sk.badand.mafuti.model.match.result.Result;
import sk.badand.math.Randomizer;

/**
 *
 * @author abadinka
 */
public class MockMatch implements PlayableMatch {
    private static final Logger LOG = Logger.getLogger(MockMatch.class.getName());

    private static final int TOP_PLAYERS_COUNT = 5;

    private PlayingTeam homeTeam = new MockTeam(new Randomizer());
    private PlayingTeam awayTeam = new MockTeam(new Randomizer());
    private final PlayableStadium stadium;
    private final MatchEngine matchEngine = new SimpleMatchEngine(homeTeam, awayTeam);

    public MockMatch() {
        this.stadium = homeTeam.getStadium();
    }

    public MockMatch(PlayingTeam homeTeam, PlayingTeam awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.stadium = homeTeam.getStadium();
    }

    @Override
    public void play() {
        LOG.log(Level.FINE, "homeTeam strength overal: {0}", homeTeam.strengthOveral());
        LOG.log(Level.FINE, "awayTeam strength overal: {0}", awayTeam.strengthOveral());
        matchEngine.inWeather(getWeather())
                .atDate(getPlayDate())
                .atStadium(stadium)
                .play(this);
    }

    @Override
    public String getHomeTeamName() {
        return homeTeam.getNameShort();
    }

    @Override
    public String getAwayTeamName() {
        return awayTeam.getNameShort();
    }

    @Override
    public List<Player> getHomeTop5Players() {
        return homeTeam.getPlayers().stream()
                .filter(player -> player.isPlaying())
                .sorted(Comparator.comparing(Player::overallRating).reversed())
                .limit(TOP_PLAYERS_COUNT)
                .collect(Collectors.toList());
    }

    @Override
    public List<Player> getAwayTop5Players() {
        return awayTeam.getPlayers().stream()
                .filter(player -> player.isPlaying())
                .sorted(Comparator.comparing(Player::overallRating).reversed())
                .limit(TOP_PLAYERS_COUNT)
                .collect(Collectors.toList());
    }

    @Override
    public String getStadiumName() {
        return stadium.getName();
    }

    @Override
    public String getAttendance() {
        return "44444";
    }

    @Override
    public LocalDate getPlayDate() {
        return LocalDate.now();
    }

    @Override
    public String getPlayTime() {
        return "18:45";
    }

    @Override
    public Weather getWeather() {
        return Weather.CLOUDY;
    }

    @Override
    public PlayingTeam getManagerTeam() {
        return homeTeam;
    }

    @Override
    public Result result() {
        return matchEngine.result();
    }
}

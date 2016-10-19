/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.match.engine;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import sk.badand.mafuti.model.match.*;
import sk.badand.mafuti.model.match.result.Result;

/**
 * @author abadinka
 */
public class SimpleResult implements Result {
    private static final Logger LOG = Logger.getLogger(SimpleResult.class.getName());
    private static final byte BEST_PLAYER_LIMIT = 7;

    private Match match;
    protected PlayingTeam awayTeam;
    protected PlayingTeam homeTeam;
    protected LocalDate playDate;
    protected PlayableStadium stadium;
    protected TeamMatchStats awayTeamStatistics;
    protected TeamMatchStats homeTeamStatistics;
    private List<PlayerStatistics> homePlayerStats;
    private List<PlayerStatistics> awayPlayerStats;

    public SimpleResult(Match match, PlayingTeam homeTeam, PlayingTeam awayTeam, LocalDate playDate, PlayableStadium stadium, TeamMatchStats homeTeamStatistics, TeamMatchStats awayTeamStatistics) {
        this.match = match;
        this.awayTeam = awayTeam;
        this.homeTeam = homeTeam;
        this.playDate = playDate;
        this.stadium = stadium;
        this.awayTeamStatistics = awayTeamStatistics;
        this.homeTeamStatistics = homeTeamStatistics;
        buildHomePlayerStats();
        buildAwayPlayerStats();
    }

    @Override
    public short getAwayGoals() {
        return awayTeamStatistics.getGoals();
    }

    @Override
    public short getHomeGoals() {
        return homeTeamStatistics.getGoals();
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
    public TeamMatchStats getHomeTeamStatistics() {
        return homeTeamStatistics;
    }

    @Override
    public TeamMatchStats getAwayTeamStatistics() {
        return awayTeamStatistics;
    }

    @Override
    public List<PlayerStatistics> homePlayerStats() {
        return homePlayerStats;
    }

    @Override
    public List<PlayerStatistics> awayPlayerStats() {
        return awayPlayerStats;
    }

    @Override
    public List<PlayerStatistics> awayBestPlayers() {
        return awayPlayerStats.stream()
                .sorted((player1, player2) -> player2.matchRating() - player1.matchRating())
                .limit(BEST_PLAYER_LIMIT)
                .collect(Collectors.toList());
    }

    @Override
    public List<PlayerStatistics> homeBestPlayers() {
        return homePlayerStats.stream()
                .sorted((player1, player2) -> player2.matchRating() - player1.matchRating())
                .limit(BEST_PLAYER_LIMIT)
                .collect(Collectors.toList());
    }

    private void buildHomePlayerStats() {
        homePlayerStats = new ArrayList<>();

        for (Player player : homeTeam.getPlayers()) {
            homePlayerStats.add(new PlayerStatistics(player, match, (short) 0, (short) 0)
                    .withResult(getHomeGoals(), getAwayGoals()));
        }
        createStats(getHomeGoals(), homeTeam, homePlayerStats);
    }

    private void buildAwayPlayerStats() {
        awayPlayerStats = new ArrayList<>();

        for (Player player : awayTeam.getPlayers()) {
            awayPlayerStats.add(new PlayerStatistics(player, match, (short) 0, (short) 0)
                    .withResult(getAwayGoals(), getHomeGoals()));
        }
        createStats(getAwayGoals(), awayTeam, awayPlayerStats);
    }

    private void createStats(int goalsToAssign, PlayingTeam team, List<PlayerStatistics> playerStats) {

        LOG.fine("goalsToAssing " + goalsToAssign);
        while (goalsToAssign > 0) {
            final Player scorer = team.getRandomScorer();
            Player randomAssistant = team.getRandomAssistant();
            while (scorer.equals(randomAssistant)) {
                randomAssistant = team.getRandomAssistant();
            }
            final Player assistant = randomAssistant;
            playerStats
                    .parallelStream()
                    .forEach(ps -> {
                        if (ps.player().equals(scorer)) {
                            ps.addGoalsScored((short) 1);
                        }
                        if (ps.player().equals(assistant)) {
                            ps.addAssists((short) 1);
                        }
                    });
            goalsToAssign--;
        }
        LOG.fine("goalsToAssing " + goalsToAssign);
    }
}

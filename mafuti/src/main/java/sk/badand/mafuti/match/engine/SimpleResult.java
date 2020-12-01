/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.match.engine;

import sk.badand.mafuti.services.data.mock.MockTeam;
import sk.badand.mafuti.model.club.Stadium;
import sk.badand.mafuti.model.club.Team;
import sk.badand.mafuti.model.match.Match;
import sk.badand.mafuti.model.match.Player;
import sk.badand.mafuti.model.match.PlayerStatistics;
import sk.badand.mafuti.model.match.TeamMatchStats;
import sk.badand.mafuti.model.match.result.Result;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @author abadinka
 */
public class SimpleResult implements Result {
    private static final Logger LOG = Logger.getLogger(SimpleResult.class.getName());
    private static final byte BEST_PLAYER_LIMIT = 5;

    private Match match;
    protected Team awayTeam;
    protected Team homeTeam;
    protected LocalDate playDate;
    protected Stadium stadium;
    protected TeamMatchStats awayTeamStatistics;
    protected TeamMatchStats homeTeamStatistics;
    private List<PlayerStatistics> homePlayerStats;
    private List<PlayerStatistics> awayPlayerStats;

    public SimpleResult(Match match, Team homeTeam, Team awayTeam, LocalDate playDate, Stadium stadium, TeamMatchStats homeTeamStatistics, TeamMatchStats awayTeamStatistics) {
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
        return awayTeam.getTeamName();
    }

    @Override
    public String getHomeTeamName() {
        return homeTeam.getTeamName();
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
                .filter(playerStats -> playerStats.matchRating() > 6)
                .sorted((playerStats1, playerStats2) -> playerStats2.matchRating() - playerStats1.matchRating())
                .limit(BEST_PLAYER_LIMIT)
                .collect(Collectors.toList());
    }

    @Override
    public List<PlayerStatistics> homeBestPlayers() {
        return homePlayerStats.stream()
                .filter(playerStats -> playerStats.matchRating() > 6)
                .sorted((playerStats1, playerStats2) -> playerStats2.matchRating() - playerStats1.matchRating())
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

    private void createStats(int goalsToAssign, Team team, List<PlayerStatistics> playerStats) {
        while (goalsToAssign > 0) {
            final Player scorer = ((MockTeam)team).getRandomScorer();
            Player randomAssistant = ((MockTeam)team).getRandomAssistant();
            while (scorer.equals(randomAssistant)) {
                randomAssistant = ((MockTeam)team).getRandomAssistant();
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
    }
}

/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.model.match.result;

import sk.badand.mafuti.model.match.PlayerStatistics;
import sk.badand.mafuti.model.match.TeamMatchStats;

import java.util.List;

/**
 *
 * @author abadinka
 */
public interface Result {

    String getAwayTeamName();

    String getHomeTeamName();
    
    short getAwayGoals();
    
    short getHomeGoals();

    TeamMatchStats getHomeTeamStatistics();

    TeamMatchStats getAwayTeamStatistics();

    List<PlayerStatistics> homePlayerStats();

    List<PlayerStatistics> awayPlayerStats();

    List<PlayerStatistics> awayBestPlayers();

    List<PlayerStatistics> homeBestPlayers();
}

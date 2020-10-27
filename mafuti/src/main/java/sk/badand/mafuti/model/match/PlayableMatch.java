/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.model.match;

import sk.badand.mafuti.model.club.Team;
import sk.badand.mafuti.model.common.Weather;

import java.util.List;

/**
 *
 * @author abadinka
 */
public interface PlayableMatch extends Match {

    List<Player> getAwayTop5Players();

    List<Player> getHomeTop5Players();

    Weather getWeather();

    String getPlayTime();

    Team getManagerTeam();
}

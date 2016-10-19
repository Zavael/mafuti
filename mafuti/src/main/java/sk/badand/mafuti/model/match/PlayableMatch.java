/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.model.match;

import java.util.List;
import sk.badand.mafuti.model.common.Weather;

/**
 *
 * @author abadinka
 */
public interface PlayableMatch extends Match {

    List<Player> getAwayTop5Players();

    List<Player> getHomeTop5Players();

    Weather getWeather();

    String getPlayTime();

    public PlayingTeam getManagerTeam();
}

/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.model.match;

import java.time.LocalDate;
import java.util.Observer;
import sk.badand.mafuti.match.engine.ObservableEvents;
import sk.badand.mafuti.model.common.Weather;
import sk.badand.mafuti.model.match.result.Result;

/**
 *
 * @author abadinka
 */
public interface MatchEngine {

    MatchEngine inWeather(Weather weather);

    MatchEngine atDate(LocalDate date);

    MatchEngine atStadium(PlayableStadium stadium);

    MatchEngine withObservers(ObservableEvents events, Observer... observers);

    void play(Match match);

    Result result();
}

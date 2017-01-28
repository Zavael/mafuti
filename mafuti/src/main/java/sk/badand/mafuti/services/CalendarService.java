/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.services;

import sk.badand.mafuti.model.Team;
import sk.badand.mafuti.model.match.PlayableMatch;
import sk.badand.mafuti.model.match.Match;
import sk.badand.mafuti.services.mock.MockMatch;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import sk.badand.math.OddsDecider;

/**
 *
 * @author abadinka
 */
public class CalendarService {

    private Calendar calendar;

    public Optional<PlayableMatch> matchToday(Team team) {
        return Optional.of(new MockMatch());
    }

    public boolean isTeamPlayingToday(Team team) {
        return new OddsDecider().decideSuccess(0.5);
    }

    public List<Match> matchesForDay(LocalDate date) {
        return Stream.of(
                new MockMatch(), 
                new MockMatch(), 
                new MockMatch())
                .collect(Collectors.toList());
    }

    public LocalDate currentDate() {
        return calendar.currentDate();
    }
    
    public void nextDay() { //TODO synchronized?
        calendar.passOneDay();
    }
    
}

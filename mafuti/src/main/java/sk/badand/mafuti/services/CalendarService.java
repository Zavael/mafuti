/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.services;

import sk.badand.mafuti.model.club.Team;
import sk.badand.mafuti.model.match.Match;
import sk.badand.mafuti.model.match.PlayableMatch;
import sk.badand.mafuti.services.data.Data;
import sk.badand.mafuti.services.data.mock.MockMatch;
import sk.badand.math.OddsDecider;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author abadinka
 */
public class CalendarService {
    private final Data data = Data.getInstance();

    private Calendar calendar;

    public Optional<PlayableMatch> matchToday(Team team) {
        return Optional.of(new MockMatch(
                team,
                team
        ));
    }

    public boolean isTeamPlayingToday(Team team) {
        return new OddsDecider().decideSuccess(0.5);
    }

    public List<Match> matchesForDay(LocalDate date) {
        return Collections.EMPTY_LIST;
    }

    public LocalDate currentDate() {
        return calendar.currentDate();
    }
    
    public void nextDay() { //TODO synchronized?
        calendar.passOneDay();
    }
    
}

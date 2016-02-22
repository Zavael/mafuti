/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.services;

import sk.badand.mafuti.services.mock.MockTeam;
import sk.badand.mafuti.services.mock.MockMatch;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import sk.badand.math.OddsDecider;

/**
 *
 * @author abadinka
 */
public class CalendarService {

    private Calendar calendar;
    private static LocalDate currentDate; // maybe need to synchronize the progress of days

    public PlayingMatch managerMatchForDay(LocalDate date) {
        return new MockMatch();
    }

    public boolean isManagerPlaying(LocalDate date) {
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
        return currentDate;
    }
    
    public void nextDay() { //TODO synchronized?
        currentDate = currentDate.plusDays(1);
    }
    
}

/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author abadinka
 */
public class CalendarService {

    private Calendar calendar;
    private static LocalDate currentDate; // maybe need to synchronize the progress of days

    public Match managerMatchForDay(LocalDate date) {
        return new MockMatch();
    }

    public boolean isManagerPlaying(LocalDate date) {
        return false;
    }

    public List<Match> matchesForDay(LocalDate date) {
        return Stream.of(new MockMatch(), new MockMatch(), new MockMatch())
                .collect(Collectors.toList());
    }

    public LocalDate currentDate() {
        return currentDate;
    }

    private final class MockMatch extends Match {

        public MockMatch() {
        }
    }
}

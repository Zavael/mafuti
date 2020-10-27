/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.services;

import java.time.LocalDate;

/**
 *
 * @author abadinka
 */
class Calendar {
    
    // duplicating different matches ordering
    /*private Map<LocalDate, List<Match>> matchesByDate;
    private Map<Team, List<Match>> matchesByTeam;*/
    private static LocalDate currentDate; // maybe need to synchronize the progress of days
    
    // subclassing to future calendar + historical calendar?

    public LocalDate currentDate() {
        return currentDate;
    }

    public void passOneDay() {
        currentDate = currentDate.plusDays(1);
    }
}

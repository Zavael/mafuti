/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.services;

import java.time.LocalDate;

/**
 *
 * @author abadinka
 */
public interface Match {

    String getAttendance();

    String getAwayTeamName();

    String getHomeTeamName();

    LocalDate getPlayDate();

    String getStadiumName();

    void play();    
}

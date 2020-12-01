/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.model.match;

import sk.badand.mafuti.model.match.result.Result;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author abadinka
 */
public interface Match extends Serializable {

    String getAwayTeamName();

    String getHomeTeamName();

    LocalDate getPlayDate();

    String getStadiumName();

    String getAttendance();

    void play();    

    Result result();
}

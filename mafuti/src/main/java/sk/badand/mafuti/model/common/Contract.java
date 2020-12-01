/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.model.common;

import sk.badand.mafuti.model.Club;
import sk.badand.mafuti.model.club.SquadStatus;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author abadinka
 */
public interface Contract extends Serializable {
    Person person();

    Club club();

    int wage();

    LocalDate start();

    LocalDate end();

    SquadStatus promisedStatus();
}

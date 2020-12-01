/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.model.common;

import sk.badand.mafuti.model.Club;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

/**
 *
 * @author abadinka
 */
public interface Person extends Nameable {
    
    Object key();
    
    LocalDate getBirthDate();

    @Override
    default String getFullName() {
        return firstName() + " " + lastName();
    }

    Short morale();
    default Morale getMorale() {
        return Morale.mapFromInt(morale());
    };

    Integer reputation();

    /**
     * Reputation int value mapped to enum
     * @return
     */
    Reputation getReputation();

    Collection<Nation> nationalities();

    Nation getMainNationality();

    Collection skills();

    //Contract contract();

    int getWage();

    LocalDate getExpiration();

    PersonType getPersonType();

    int getEstimateValue();

    Optional<Club> getClub();
}

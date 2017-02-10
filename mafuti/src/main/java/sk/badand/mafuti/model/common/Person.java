/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.model.common;

import java.time.LocalDate;
import java.util.Collection;

/**
 *
 * @author abadinka
 */
public interface Person {
    
    Object key();
    
    LocalDate birthDate();

    String firstName();

    String lastName();

    String middleName();

    default String getFullName() {
        return firstName() + " " + lastName();
    }

    String namePrefix();

    String nameSuffix();

    String nickname();

    Short morale();

    Integer reputation();

    Reputation getReputation();

    Collection<Nation> nationalities();

    Nation getMainNationality();

    Collection skills();

    //Contract contract();

    int getWage();

    LocalDate getExpiration();

    PersonType personType();
}

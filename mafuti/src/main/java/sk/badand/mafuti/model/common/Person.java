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

    String namePrefix();

    String nameSuffix();

    String nickname();

    Short morale();

    Integer reputation();

    Collection<Nation> nationalities();

    Collection skills();

    Contract contract();

    PersonType personType();
}

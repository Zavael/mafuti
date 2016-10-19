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
    
    public LocalDate birthDate();

    public String firstName();

    public String lastName();

    public String middleName();

    public String namePrefix();

    public String nameSuffix();

    public String nickname();

    public Short morale();

    public Integer reputation();

    public Collection<Nation> nationalities();

    public Collection<Skill> skills();

    public Contract contract();

    public PersonType personType();
}

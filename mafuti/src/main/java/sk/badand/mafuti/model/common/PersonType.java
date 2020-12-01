/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.model.common;

import java.io.Serializable;

/**
 *
 * @author abadinka
 */
public enum PersonType implements Serializable {
    PLAYER("person.type.player"),
    SCOUT("person.type.scout"),
    MANAGER("person.type.manager"),
    COACH("person.type.coach"),
    PHYSIO("person.type.physio");
    
    public final String key;
    public final String bundleKey;

    PersonType(String key) {
        this.key = key;
        this.bundleKey = key;
    }
}

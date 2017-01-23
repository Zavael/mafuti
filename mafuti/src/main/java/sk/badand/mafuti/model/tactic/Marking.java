/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.model.tactic;

/**
 *
 * @author abadinka
 */
public enum Marking {
    
    ZONAL("marking.zonal"),
    MIXED("marking.mixed"),
    MAN("marking.man");
    
    public final String key;

    Marking(String key) {
        this.key = key;
    }

    public static Marking predefined() {
        return MIXED;
    }
}

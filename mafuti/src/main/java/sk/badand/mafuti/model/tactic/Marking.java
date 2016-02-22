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
    
    private String key;

    private Marking(String key) {
        this.key = key;
    }

    public String key() {
        return key;
    }
}

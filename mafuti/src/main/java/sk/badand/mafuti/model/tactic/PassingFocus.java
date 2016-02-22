/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.model.tactic;

/**
 *
 * @author abadinka
 */
public enum PassingFocus {
    
    ON_SIDES("passFocus.onSides"),
    MIXED("passFocus.mixed"),
    IN_MIDDLE("passFocus.inMiddle");
        
    private String key;

    private PassingFocus(String key) {
        this.key = key;
    }

    public String key() {
        return key;
    }
}

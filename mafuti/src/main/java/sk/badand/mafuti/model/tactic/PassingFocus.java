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
        
    public final String key;

    PassingFocus(String key) {
        this.key = key;
    }

    public static PassingFocus predefined() {
        return MIXED;
    }
}

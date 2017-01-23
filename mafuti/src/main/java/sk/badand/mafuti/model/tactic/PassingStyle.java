/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.model.tactic;

/**
 *
 * @author abadinka
 */
public enum PassingStyle {
    SHORT("passStyle.short"),
    MIXED("passStyle.mixed"),
    LONG("passStyle.long");
        
    public final String key;

    PassingStyle(String key) {
        this.key = key;
    }

    public static PassingStyle predefined() {
        return MIXED;
    }
}

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
        
    private String key;

    private PassingStyle(String key) {
        this.key = key;
    }

    public String key() {
        return key;
    }

    public static PassingStyle predefined() {
        return MIXED;
    }
}

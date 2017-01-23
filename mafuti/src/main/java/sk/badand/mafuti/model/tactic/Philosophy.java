/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.model.tactic;

/**
 *
 * @author abadinka
 */
public enum Philosophy {
    ATTACK("philosophy.attack"),
    NORMAL("philosophy.normal"),
    DEFEND("philosophy.defend");
    
    public final String key;

    Philosophy(String key) {
        this.key = key;
    }

    public static Philosophy predefined() {
        return NORMAL;
    }
}

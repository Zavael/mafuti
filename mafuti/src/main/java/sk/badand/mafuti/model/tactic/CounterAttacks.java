/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.model.tactic;

/**
 *
 * @author abadinka
 */
public enum CounterAttacks {
    
    NEVER("counterAtt.never"),
    SOMETIMES("counterAtt.sometimes"),
    OFTEN("counterAtt.often");
    
    public final String key;

    CounterAttacks(String key) {
        this.key = key;
    }

    public static CounterAttacks predefined() {
        return SOMETIMES;
    }
}

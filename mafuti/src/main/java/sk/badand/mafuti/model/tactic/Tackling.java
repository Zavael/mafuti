/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.model.tactic;

/**
 *
 * @author abadinka
 */
public enum Tackling {
    EASY("tackling.easy"),
    NORMAL("tackling.normal"),
    HARD("tackling.hard");
    
    private String key;

    private Tackling(String key) {
        this.key = key;
    }

    public String key() {
        return key;
    }
}
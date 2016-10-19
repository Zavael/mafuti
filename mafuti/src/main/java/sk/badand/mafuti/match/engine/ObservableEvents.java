/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.match.engine;

/**
 *
 * @author abadinka
 */
public enum ObservableEvents {
    FOUL(0x000001),
    OUT(0x000010),
    ALL(0x111111);
    //... study how to do this :D/
    
    double key;

    private ObservableEvents(double key) {
        this.key = key;
    }
}

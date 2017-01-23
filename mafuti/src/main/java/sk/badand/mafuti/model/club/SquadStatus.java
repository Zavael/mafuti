/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.model.club;

/**
 *
 * @author abadinka
 */
public enum SquadStatus {
    INDISPENSABLE("squad.status.indispensable"),
    IMPORTANT("squad.status.important"),
    BACKUP("squad.status.backup"),
    TOPYOUNGSTER("squad.status.topyoung"),
    DECENTYOUNGSTER("squad.status.decentyoung"),
    NOTNEEDED("squad.status.notneeded");

    private final String bundleKey;

    SquadStatus(String key) {
        this.bundleKey = "lbl." + key;
    }
}

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

    public final String key;

    SquadStatus(String key) {
        this.key = key;
    }
}

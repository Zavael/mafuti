package sk.badand.mafuti.model.common;

import java.io.Serializable;

/**
 * Created by abadinka.
 */
public enum Reputation implements Serializable {
    LOCAL("reputation.local"),
    REGIONAL("reputation.regional"),
    NATIONAL("reputation.national"),
    CONTINENTAL("reputation.continental");

    public final String key;

    Reputation(String key) {

        this.key = key;
    }
}

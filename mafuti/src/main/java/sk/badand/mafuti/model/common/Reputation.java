package sk.badand.mafuti.model.common;

/**
 * Created by abadinka.
 */
public enum Reputation {
    LOCAL("reputation.local"),
    REGIONAL("reputation.regional"),
    NATIONAL("reputation.national"),
    CONTINENTAL("reputation.continental");

    public final String key;

    Reputation(String key) {

        this.key = key;
    }
}

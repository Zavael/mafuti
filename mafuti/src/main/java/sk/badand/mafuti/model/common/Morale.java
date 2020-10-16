package sk.badand.mafuti.model.common;

public enum Morale {
    ANGRY("morale.angry"),
    UNHAPPY("morale.unhappy"),
    NORMAL("morale.normal"),
    HAPPY("morale.happy"),
    EXCITED("morale.excited");

    public final String key;

    Morale(String key) {
        this.key = key;
    }
}

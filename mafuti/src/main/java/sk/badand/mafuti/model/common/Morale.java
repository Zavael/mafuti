package sk.badand.mafuti.model.common;

public enum Morale {
    ANGRY("morale.angry"),
    UNHAPPY("morale.unhappy"),
    NORMAL("morale.normal"),
    HAPPY("morale.happy"),
    EXCITED("morale.excited");

    public final String key;
    public static final short MAX = 100;

    Morale(String key) {
        this.key = key;
    }

    static Morale mapFromInt(short morale) {
        if (morale < 20) {
            return ANGRY;
        } else if (morale < 40) {
            return UNHAPPY;
        } else if (morale < 60) {
            return NORMAL;
        } else if (morale < 80) {
            return HAPPY;
        } else {
            return EXCITED;
        }
    }
}

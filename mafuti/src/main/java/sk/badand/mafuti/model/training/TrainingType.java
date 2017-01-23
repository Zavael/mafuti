package sk.badand.mafuti.model.training;

/**
 * Created by abadinka.
 */
public enum TrainingType {
    NATURAL("training.type.natural"),
    ATTACKING("training.type.attacking"),
    CENTRAL("training.type.central"),
    WING("training.type.wing"),
    DEFENDING("training.type.defending"),
    BALLCONTROL("training.type.ballcontrol"),
    GOALKEEPING("training.type.goalkeeping");

    public final String key;

    TrainingType(String key) {
        this.key = key;
    }
}

package sk.badand.mafuti.model.player;

/**
 * Created by abadinka.
 */
public enum FitnessStatus {
    HEALTHY("fitness.healthy", 1.0),
    TIRED("fitness.tired", 0.7), //TODO under 70% of condition some effects come to play
    INJURED("fitness.injured", 0.3);

    public final String key;
    public final double ratingAffect;

    FitnessStatus(String key, double ratingAffect) {
        this.key = key;
        this.ratingAffect = ratingAffect;
    }
}

package sk.badand.mafuti.model.player;

import java.io.Serializable;

/**
 * Created by abadinka.
 */
public interface Injurable extends Serializable {
    default boolean isInjured() {
        return FitnessStatus.INJURED.equals(getFitness().getStatus());
    }

    Fitness getFitness();

    int getHealingTime();
}

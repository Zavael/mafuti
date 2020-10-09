package sk.badand.mafuti.model.player;

import sk.badand.mafuti.model.common.Nameable;

/**
 * Created by abadinka.
 */
public interface Injurable {
    default boolean isInjured() {
        return FitnessStatus.INJURED.equals(getFitness().getStatus());
    }

    Fitness getFitness();

    int getHealingTime();
}

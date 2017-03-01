package sk.badand.mafuti.model.player;

import sk.badand.mafuti.model.common.Nameable;

/**
 * Created by abadinka.
 */
public interface Injurable extends Nameable {
    boolean isInjured();

    int getHealingTime();
}

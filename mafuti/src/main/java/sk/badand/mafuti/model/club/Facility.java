package sk.badand.mafuti.model.club;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class Facility implements Serializable {
    transient static final short ONE_LEVEL_WEEKLY_COST = 421;
    transient static final short MAX_LEVEL = 30;
    transient static final int ONE_WEEK_UPGRADE_COST = 15321;
    short level;
    String image;
    /**
     * affects upgrade, maintenance cost and upgrade duration
     * ranges 1-3
     */
    byte facilitySize;

    //TODO extract calculations to lib and parametrize level to be able to show next upgrade costs and duration
    public short getWeeksToUpgrade() {
        return (short) ((level * 1.2 * 1.2 * facilitySize)/2 + 2);
    }

    public int getWeeklyCost() {
        return level * level * ONE_LEVEL_WEEKLY_COST * facilitySize * facilitySize;
    }

    public int getUpgradeCost() {
        return level * getWeeksToUpgrade() * ONE_WEEK_UPGRADE_COST * facilitySize;
    }
}

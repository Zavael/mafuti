package sk.badand.mafuti.data.mock;

import sk.badand.mafuti.model.Manager;
import sk.badand.mafuti.model.common.Morale;
import sk.badand.mafuti.model.common.Nation;
import sk.badand.mafuti.model.common.Reputation;
import sk.badand.math.Randomizer;

import java.time.LocalDate;
import java.util.Collection;

/**
 * Created by abadinka.
 */
public class MockManager implements Manager {
    private static final Randomizer rand = new Randomizer();
    private short morale = (short) rand.nextRandomInt(Morale.MAX);

    @Override
    public Object key() {
        return null;
    }

    @Override
    public LocalDate getBirthDate() {
        return null;
    }

    @Override
    public String firstName() {
        return null;
    }

    @Override
    public String lastName() {
        return null;
    }

    @Override
    public String middleName() {
        return null;
    }

    @Override
    public String namePrefix() {
        return null;
    }

    @Override
    public String nameSuffix() {
        return null;
    }

    @Override
    public String nickname() {
        return null;
    }

    @Override
    public Short morale() {
        return morale;
    }

    @Override
    public Integer reputation() {
        return null;
    }

    @Override
    public Reputation getReputation() {
        return null;
    }

    @Override
    public Collection<Nation> nationalities() {
        return null;
    }

    @Override
    public Nation getMainNationality() {
        return null;
    }

    @Override
    public Collection skills() {
        return null;
    }

    @Override
    public int getWage() {
        return 0;
    }

    @Override
    public LocalDate getExpiration() {
        return null;
    }

    @Override
    public int getEstimateValue() {
        return (int) rand.nextDouble(1,200) * 10000;
    }
}

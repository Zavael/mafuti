package sk.badand.mafuti.services.data.mock;

import lombok.Setter;
import sk.badand.mafuti.model.Club;
import sk.badand.mafuti.model.Manager;
import sk.badand.mafuti.model.common.Morale;
import sk.badand.mafuti.model.common.Nation;
import sk.badand.mafuti.model.common.Reputation;
import sk.badand.math.Randomizer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by abadinka.
 */
public class MockManager implements Manager {
    private static final Randomizer rand = new Randomizer();
    private final String firstName;
    private final String lastName;
    private final LocalDate birthdate;
    private final List<Nation> nationalities;
    private final boolean isHuman;
    private short morale = (short) rand.nextRandomInt(Morale.MAX);
    @Setter
    private Club club;

    public MockManager(String firstName, String lastName, LocalDate birthdate, Nation nation, boolean isHuman) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.nationalities = new ArrayList<>();
        this.nationalities.add(nation);
        this.isHuman = isHuman;
    }

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
        return firstName;
    }

    @Override
    public String lastName() {
        return lastName;
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
        return nationalities;
    }

    @Override
    public Nation getMainNationality() {
        return nationalities.get(0);
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

    @Override
    public Optional<Club> getClub() {
        return Optional.ofNullable(club);
    }

    @Override
    public boolean isHuman() {
        return isHuman;
    }
}

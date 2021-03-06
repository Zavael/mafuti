package sk.badand.mafuti.services.data.mock;

import sk.badand.mafuti.model.Club;
import sk.badand.mafuti.model.Staff;
import sk.badand.mafuti.model.common.*;
import sk.badand.math.Randomizer;
import sk.badand.text.StrGenerator;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by abadinka.
 */
public class MockStaff implements Staff {
    private static final StrGenerator strgen = new StrGenerator();
    private final String lastName = strgen.generateDesignation(10);
    private final String firstName = strgen.generateDesignation(10);
    public static final Randomizer rand = new Randomizer();
    private final Contract contract;
    private PersonType personType;

    public MockStaff() {
        int type = rand.nextRandomInt(3);
        switch (type) {
            case 0:
                personType = PersonType.COACH;
                break;
            case 1:
                personType = PersonType.PHYSIO;
                break;
            case 2:
                personType = PersonType.SCOUT;
                break;
        }
        contract = new MockContract();
    }

    @Override
    public Object key() {
        return UUID.randomUUID();
    }

    @Override
    public LocalDate getBirthDate() {
        return LocalDate.now().minusYears(rand.nextRandomInt(17, 35));
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
        return "";
    }

    @Override
    public String namePrefix() {
        return "";
    }

    @Override
    public String nameSuffix() {
        return "";
    }

    @Override
    public String nickname() {
        return "";
    }

    @Override
    public Short morale() {
        return (short) rand.nextRandomInt(Morale.MAX);
    }

    @Override
    public Integer reputation() {
        return 20;
    }

    @Override
    public Reputation getReputation() {
        return Reputation.REGIONAL;
    }

    @Override
    public Collection<Nation> nationalities() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public Nation getMainNationality() {
        return new MockNation();
    }

    @Override
    public Collection skills() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public int getWage() {
        return contract.wage();
    }

    @Override
    public LocalDate getExpiration() {
        return contract.end();
    }

    @Override
    public PersonType getPersonType() {
        return personType;
    }

    @Override
    public int getEstimateValue() {
        return rand.nextRandomInt(50000);
    }

    @Override
    public Optional<Club> getClub() {
        return Optional.ofNullable(contract.club()); //FIXME define empty contract or optional
    }

    @Override
    public String toString() {
        return "MockStaff{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", contract=" + contract +
                ", personType=" + personType +
                '}';
    }
}

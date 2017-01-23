/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.services.mock;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Collections;
import sk.badand.mafuti.model.common.Contract;
import sk.badand.mafuti.model.common.Nation;
import sk.badand.mafuti.model.common.PersonType;
import sk.badand.mafuti.model.match.PlayerPosition;
import sk.badand.mafuti.model.match.Player;
import sk.badand.mafuti.model.player.PlayerSkill;
import sk.badand.math.Randomizer;
import sk.badand.text.StrGenerator;

public final class MockPlayer implements Player {

    private static final StrGenerator strgen = new StrGenerator();
    private final int rating = new Randomizer().nextRandomInt(6, 40);
    private final String shortName;
    private final PlayerPosition position;
    private PlayerPosition currentPosition;
    private final LocalDate birthDate = LocalDate.now().minus(new Randomizer().nextRandomInt(17, 35), ChronoUnit.YEARS).minus(new Randomizer().nextRandomInt(0, 365), ChronoUnit.DAYS);
    private final String firstName = strgen.generateDesignation(10);
    private final String lastName = strgen.generateDesignation(10);
    private final Short morale = 200; //??wtf
    private final Integer reputation = 200; //??wtf;
    private final Contract contract;

    public MockPlayer(PlayerPosition position) {
        this.position = position;
        this.currentPosition = this.position;
        shortName = firstName().substring(0, 1) + ". " + lastName();
        contract = new MockContract();
    }

    @Override
    public boolean isPlaying() {
        return true;
    }

    @Override
    public int overallRating() {
        return rating;
    }

    @Override
    public String toString() {
        return shortName()
                + ", skill:"
                + overallRating()
                + ", position:"
                + currentPosition;
    }

    @Override
    public LocalDate birthDate() {
        return birthDate;
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
        return morale;
    }

    @Override
    public Integer reputation() {
        return reputation;
    }

    @Override
    public Collection<Nation> nationalities() {
        return Collections.emptyList();
    }

    @Override
    public Collection<PlayerSkill> skills() {
        return Collections.emptyList();
    }

    @Override
    public Contract contract() {
        return contract;
    }

    @Override
    public PersonType personType() {
        return PersonType.PLAYER;
    }

    private String shortName() {
        return shortName;
    }

    @Override
    public String positionAbbr() {
        return position.abbreviation;
    }

    @Override
    public boolean isPlayingOnPosition(PlayerPosition position) {
        return this.currentPosition == position;
    }

    @Override
    public PlayerPosition getCurrentPosition() {
        return currentPosition;
    }

    @Override
    public Object key() {
        return shortName + birthDate.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Player && this.key().equals(((Player)obj).key());
    }
}

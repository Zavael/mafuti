package sk.badand.mafuti.services.mock;

import sk.badand.mafuti.model.Club;
import sk.badand.mafuti.model.club.SquadStatus;
import sk.badand.mafuti.model.common.Contract;
import sk.badand.mafuti.model.common.Person;
import sk.badand.mafuti.model.match.PlayerPosition;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

/**
 * Created by abadinka.
 */
public class MockContract implements Contract {
    @Override
    public Person person() {
        return new MockPlayer(PlayerPosition.MIDFIELDER);
    }

    @Override
    public Club club() {
        return new MockClub();
    }

    @Override
    public int wage() {
        return 15000;
    }

    @Override
    public LocalDate start() {
        return LocalDate.now();
    }

    @Override
    public Optional<LocalDate> end() {
        return Optional.of(LocalDate.now().plus(2, ChronoUnit.YEARS));
    }

    @Override
    public SquadStatus promisedStatus() {
        return SquadStatus.IMPORTANT;
    }
}
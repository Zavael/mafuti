package sk.badand.mafuti.data.mock;

import sk.badand.mafuti.model.Club;
import sk.badand.mafuti.model.club.SquadStatus;
import sk.badand.mafuti.model.common.Contract;
import sk.badand.mafuti.model.common.Person;
import sk.badand.mafuti.model.match.PlayerPosition;

import java.time.LocalDate;

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
        return null;
    }

    @Override
    public int wage() {
        return 15000;
    }

    @Override
    public LocalDate start() {
        return LocalDate.now().minusYears(1);
    }

    @Override
    public LocalDate end() {
        return LocalDate.now().plusYears(2);
    }

    @Override
    public SquadStatus promisedStatus() {
        return SquadStatus.IMPORTANT;
    }
}

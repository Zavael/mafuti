package sk.badand.mafuti.services.mock;

import sk.badand.mafuti.model.Budget;
import sk.badand.mafuti.model.Manager;
import sk.badand.mafuti.model.ManagerClub;
import sk.badand.mafuti.model.Team;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by abadinka.
 */
public class MockClub implements ManagerClub {
    @Override
    public List<Team> getTeams() {
        return Stream.of(
                new MockTeam((short) 0),
                new MockTeam((short) 1),
                new MockTeam((short) 2))
                .collect(Collectors.toList());
    }

    @Override
    public Budget getBudget() {
        return null;
    }

    @Override
    public Manager getManager() {
        return null;
    }
}

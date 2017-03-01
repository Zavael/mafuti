package sk.badand.mafuti.model;

import sk.badand.mafuti.services.mock.MockManager;

import java.util.List;

/**
 * Created by abadinka.
 */
public class Club{
    private final Object key;
    private final MockManager mockManager;
    private final List<Team> teams;
    private Budget budget;

    public Club(Object key, MockManager mockManager, List<Team> teams, Budget budget) {
        this.key = key;
        this.mockManager = mockManager;
        this.teams = teams;
        this.budget = budget;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public int getBudget() {
        return budget.getMoneyAmount();
    }

    public Manager getManager() {
        return mockManager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Club club = (Club) o;

        return key.equals(club.key);
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }
}

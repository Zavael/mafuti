package sk.badand.mafuti.model.league;

import sk.badand.mafuti.model.common.Nation;

import java.util.List;

/**
 * Created by abadinka.
 */
public class LeagueSystem {

    private final int id;
    private final Nation nation;
    private final List<LeagueLevel> leagueLevels;

    public LeagueSystem(int id, Nation nation, List<LeagueLevel> leagueLevels) {
        this.id = id;
        this.nation = nation;
        this.leagueLevels = leagueLevels;
    }

    public Nation getNation() {
        return nation;
    }

    public List<LeagueLevel> getLeagueLevels() {
        return leagueLevels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeagueSystem that = (LeagueSystem) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}

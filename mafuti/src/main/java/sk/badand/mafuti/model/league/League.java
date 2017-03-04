package sk.badand.mafuti.model.league;

import sk.badand.mafuti.model.Club;

import java.util.List;

/**
 * Created by abadinka.
 */
public class League {
    private final int id;
    private final String name;
    private final LeagueSystem leagueSystem; //FIXME is necessary?
    private final List<Club> clubs;

    public League(int id, String name, LeagueSystem leagueSystem, List<Club> clubs) {
        this.id = id;
        this.name = name;
        this.leagueSystem = leagueSystem;
        this.clubs = clubs;
    }

    public String getName() {
        return name;
    }

    public LeagueSystem getLeagueSystem() {
        return leagueSystem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        League league = (League) o;

        return id == league.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public List<Club> getClubs() {
        return clubs;
    }
}

package sk.badand.mafuti.model.league;

/**
 * Created by abadinka.
 */
public class League {
    private final int id;
    private final String name;
    private final LeagueSystem leagueSystem; //FIXME is necessary?

    public League(int id, String name, LeagueSystem leagueSystem) {
        this.id = id;
        this.name = name;
        this.leagueSystem = leagueSystem;
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
}

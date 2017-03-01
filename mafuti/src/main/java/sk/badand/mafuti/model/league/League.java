package sk.badand.mafuti.model.league;

/**
 * Created by abadinka.
 */
public class League {
    private final int id;
    private final String name;
    private final League league; //FIXME is necessary?

    public League(int id, String name, League league) {
        this.id = id;
        this.name = name;
        this.league = league;
    }

    public String getName() {
        return name;
    }

    public League getLeague() {
        return league;
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

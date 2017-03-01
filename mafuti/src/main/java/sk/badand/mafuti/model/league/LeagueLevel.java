package sk.badand.mafuti.model.league;

import java.util.List;

/**
 * Created by abadinka.
 */
public class LeagueLevel {

    private final int id;
    private final byte promotedCount;
    private final List<League> leagues;

    public LeagueLevel(int id, byte promotedCount, List<League> leagues) {
        this.id = id;
        this.promotedCount = promotedCount;
        this.leagues = leagues;
    }

    public byte getPromotedCount() {
        return promotedCount;
    }

    public List<League> getLeagues() {
        return leagues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeagueLevel that = (LeagueLevel) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}

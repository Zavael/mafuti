package sk.badand.mafuti.model.league;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import sk.badand.mafuti.model.club.Team;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abadinka.
 */
@RequiredArgsConstructor
public class League implements Serializable {
    private static final long serialVersionUID = -1797290337003499505L;
    private final int id;
    @Getter
    private final String name;
    @Getter
    private List<Team> teams = new ArrayList<>();

    public void addTeam(Team team) {
        teams.add(team);
        team.setLeague(this);
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

package sk.badand.mafuti.data;

import sk.badand.mafuti.model.Club;
import sk.badand.mafuti.model.club.Team;
import sk.badand.mafuti.model.common.Nation;
import sk.badand.mafuti.model.league.League;
import sk.badand.mafuti.model.league.LeagueSystem;
import sk.badand.mafuti.model.match.Player;

import java.util.ArrayList;
import java.util.List;

public class EmptyDataProvider implements DataProvider {
    @Override
    public List<Team> getTeams(League league) {
        return new ArrayList<>();
    }

    @Override
    public List<Club> getClubs() {
        return new ArrayList<>();
    }

    @Override
    public List<Player> getPlayers() {
        return new ArrayList<>();
    }

    @Override
    public List<Nation> getNations() {
        return new ArrayList<>();
    }

    @Override
    public List<LeagueSystem> getLeagueSystems() {
        return new ArrayList<>();
    }
}

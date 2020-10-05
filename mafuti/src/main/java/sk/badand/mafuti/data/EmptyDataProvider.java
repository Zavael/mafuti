package sk.badand.mafuti.data;

import org.apache.commons.collections4.collection.AbstractCollectionDecorator;
import sk.badand.mafuti.model.Club;
import sk.badand.mafuti.model.common.Nation;
import sk.badand.mafuti.model.league.League;
import sk.badand.mafuti.model.league.LeagueSystem;
import sk.badand.mafuti.model.match.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EmptyDataProvider implements DataProvider {
    @Override
    public List<Club> getClubs(League league) {
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

package sk.badand.mafuti.data;

import sk.badand.mafuti.model.Club;
import sk.badand.mafuti.model.club.Team;
import sk.badand.mafuti.model.common.Nation;
import sk.badand.mafuti.model.league.League;
import sk.badand.mafuti.model.league.LeagueSystem;

import java.util.List;

/**
 * Created by abadinka.
 */
public class Data {

    private static final Data instance = new Data();
    private static final DataProvider dataProvider = new MockDataProvider();

    private Data() {

    }

    public static Data getInstance() {
        return instance;
    }

    public static void loadInstance() {
        //TODO load from save file
    }

    public List<Team> getTeams(League league) {
        return dataProvider.getTeams(league);
    }

    public List<Club> getClubs() {
        return dataProvider.getClubs();
    }

    public List<LeagueSystem> getLeagueSystems() {
        return dataProvider.getLeagueSystems();
    }

    public List<Nation> getNations() {
        return dataProvider.getNations();
    }
}

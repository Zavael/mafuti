package sk.badand.mafuti.data;

import sk.badand.mafuti.model.Club;
import sk.badand.mafuti.model.league.League;
import sk.badand.mafuti.model.league.LeagueSystem;

import java.util.List;

/**
 * Created by abadinka.
 */
public class Data {

    private static final Data instance = new Data();
    private static final DataProvider dataProvider = new EmptyDataProvider();

    private Data() {

    }

    public static Data getInstance() {
        return instance;
    }

    public List<Club> getClubs(League league) {
        return dataProvider.getClubs(league);
    }

    public List<Club> getClubs() {
        return dataProvider.getClubs();
    }

    public List<LeagueSystem> getLeagueSystems() {
        return dataProvider.getLeagueSystems();
    }
}

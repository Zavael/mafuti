package sk.badand.mafuti.data;

import sk.badand.mafuti.model.Club;
import sk.badand.mafuti.model.common.Nation;
import sk.badand.mafuti.model.league.League;
import sk.badand.mafuti.model.league.LeagueSystem;

import java.util.List;

/**
 * Created by abadinka.
 */
interface DataProvider {

    List<Club> getClubs(League league);
    List<Club> getClubs();

    List<Nation> getNations();

    List<LeagueSystem> getLeagueSystems();
}

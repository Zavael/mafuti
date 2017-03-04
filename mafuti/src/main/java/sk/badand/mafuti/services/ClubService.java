package sk.badand.mafuti.services;

import sk.badand.mafuti.data.Data;
import sk.badand.mafuti.model.Club;
import sk.badand.mafuti.model.league.League;

import java.util.List;

/**
 * Created by abadinka.
 */
public class ClubService {

    public List<Club> getClubs(League league) {
        return Data.getClubs(league);
    }
}

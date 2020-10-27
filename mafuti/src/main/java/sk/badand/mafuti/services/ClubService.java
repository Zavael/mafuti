package sk.badand.mafuti.services;

import sk.badand.mafuti.data.Data;
import sk.badand.mafuti.model.club.Team;
import sk.badand.mafuti.model.league.League;

import java.util.List;

/**
 * Created by abadinka.
 */
public class ClubService {
    private final Data data = Data.getInstance();

    public List<Team> getTeams(League league) {
        return data.getTeams(league);
    }
}

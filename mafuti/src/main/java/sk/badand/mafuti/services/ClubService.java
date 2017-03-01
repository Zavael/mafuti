package sk.badand.mafuti.services;

import sk.badand.mafuti.data.Data;
import sk.badand.mafuti.model.Club;
import sk.badand.mafuti.model.Team;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abadinka.
 */
public class ClubService {

    private List<Club> clubs = new ArrayList<>();

    public ClubService() {
        clubs.addAll(Data.getClubs());
    }

    public List<Team> getTeams(Club club) {
        return clubs.get(clubs.indexOf(club)).getTeams();
    }

    public List<Club> getClubs() {
        return clubs;
    }
}

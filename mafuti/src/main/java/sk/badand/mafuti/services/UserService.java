package sk.badand.mafuti.services;

import sk.badand.mafuti.data.Data;
import sk.badand.mafuti.model.Club;

/**
 * Created by abadinka.
 */
public class UserService {

    public Club getClub() {
        return Data.getLeagueSystems().get(0).getLeagueLevels().get(0).getLeagues().get(0).getClubs().get(0);
    }
}

package sk.badand.mafuti.services;

import sk.badand.mafuti.data.Data;
import sk.badand.mafuti.model.Club;
import sk.badand.mafuti.services.mock.MockClub;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by abadinka.
 */
public class UserService {

    public Club getClub() {
        return Data.getLeagueSystems().stream()
                .findFirst()
                .flatMap(system -> system.getLeagueLevels().stream().findFirst()
                        .flatMap(level -> level.getLeagues().stream().findFirst()
                                .flatMap(league -> league.getClubs().stream().findFirst())
                        )
                )
                .orElse(new MockClub(null));
    }
}

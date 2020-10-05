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
    private final Data data = Data.getInstance();

    public Club getClub() {
        return data.getLeagueSystems().stream()
                .findFirst()
                .flatMap(system -> system.getLeagueLevels().stream().findFirst()
                        .flatMap(level -> level.getLeagues().stream().findFirst()
                                .flatMap(league -> league.getClubs().stream().findFirst())
                        )
                )
                .orElse(new MockClub(null));
    }
}

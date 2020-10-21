package sk.badand.mafuti.services;

import sk.badand.mafuti.data.Data;
import sk.badand.mafuti.model.Club;

import java.util.Optional;
import java.util.logging.Logger;

/**
 * Created by abadinka.
 */
public class UserService {
    private static final Logger LOG = Logger.getLogger(UserService.class.getName());
    private final Data data = Data.getInstance();

    public Optional<Club> getClub() {
        return data.getLeagueSystems().stream()
                .findFirst()
                .flatMap(system -> system.getLeagueLevels().stream().findFirst()
                        .flatMap(level -> level.getLeagues().stream().findFirst()
                                .flatMap(league -> league.getClubs().stream().findFirst())
                        )
                );
    }
}

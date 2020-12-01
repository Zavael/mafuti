package sk.badand.mafuti.services.data.mock;

import sk.badand.mafuti.model.Club;
import sk.badand.mafuti.model.Game;
import sk.badand.mafuti.model.Staff;
import sk.badand.mafuti.model.common.Nation;
import sk.badand.mafuti.model.league.League;
import sk.badand.mafuti.model.league.LeagueLevel;
import sk.badand.mafuti.model.league.LeagueSystem;
import sk.badand.mafuti.model.match.Player;
import sk.badand.mafuti.model.match.PlayerPosition;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by abadinka.
 */
public class MockDataProvider {
    private static final Logger LOG = Logger.getLogger(MockDataProvider.class.getName());
    private final Game game;

    public MockDataProvider() {
        LOG.fine("Generating game data...");
        List<Nation> nations = Stream.of(
                new Nation("SVK", "Slovakia"),
                new Nation("CZE", "Czech republic"))
                .collect(Collectors.toUnmodifiableList());
        List<LeagueSystem> leagueSystems = new ArrayList<>(nations.size());
        int i = 1;
        for (Nation nation : nations) {
            League league1 = new League(10000 + i, nation.country + " league " + 1);
            League league2 = new League(11000 + i, nation.country + " league " + 2);
            generateClubs(12, league1);
            generateClubs(6, league2);

            leagueSystems.add(new LeagueSystem(i++, nation, Stream.of(
                    new LeagueLevel(1000 + i, (byte) 2, Stream.of(
                            league1
                    ).collect(toList())),
                    new LeagueLevel(1100 + i, (byte) 2, Stream.of(
                            league2
                    ).collect(toList()))
            ).collect(toList())));
        }
        this.game = new Game(leagueSystems);
        LOG.log(Level.FINE, "Done. Created {0} league systems", leagueSystems.size());
    }

    private static List<Club> generateClubs(int clubsCount, League league) {
        List<Club> clubList = new ArrayList<>(clubsCount);
        for (int i = 0; i < clubsCount; i++) {
            List<Staff> staff = Stream.of(new MockStaff(), new MockStaff(), new MockStaff(), new MockStaff()).collect(Collectors.toList());
            MockClub mockClub = new MockClub(
                    new ArrayList<>(),
                    staff);
            for (short j = 0; j < 3; j++) {

                List<Player> players = Stream.of(
                        new MockPlayer(PlayerPosition.STRIKER),
                        new MockPlayer(PlayerPosition.STRIKER),
                        new MockPlayer(PlayerPosition.STRIKER),
                        new MockPlayer(PlayerPosition.WINGER),
                        new MockPlayer(PlayerPosition.WINGER),
                        new MockPlayer(PlayerPosition.WINGER),
                        new MockPlayer(PlayerPosition.MIDFIELDER),
                        new MockPlayer(PlayerPosition.MIDFIELDER),
                        new MockPlayer(PlayerPosition.MIDFIELDER),
                        new MockPlayer(PlayerPosition.WINGBACK),
                        new MockPlayer(PlayerPosition.WINGBACK),
                        new MockPlayer(PlayerPosition.WINGBACK),
                        new MockPlayer(PlayerPosition.DEFENDER),
                        new MockPlayer(PlayerPosition.DEFENDER),
                        new MockPlayer(PlayerPosition.DEFENDER),
                        new MockPlayer(PlayerPosition.GOALKEEPER),
                        new MockPlayer(PlayerPosition.GOALKEEPER)
                ).collect(toList());

                MockTeam mockTeam = new MockTeam(mockClub, j, players);
                mockClub.addTeam(mockTeam);
            }
            league.addTeam(mockClub.getTeams().get(0));
            clubList.add(mockClub);
        }
        return clubList;
    }

    public Game mockGame() {
        return game;
    }
}

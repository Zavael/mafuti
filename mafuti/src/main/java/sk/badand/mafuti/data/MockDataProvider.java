package sk.badand.mafuti.data;

import sk.badand.mafuti.model.Club;
import sk.badand.mafuti.model.Team;
import sk.badand.mafuti.model.match.Player;
import sk.badand.mafuti.model.match.PlayerPosition;
import sk.badand.mafuti.services.mock.MockClub;
import sk.badand.mafuti.services.mock.MockPlayer;
import sk.badand.mafuti.services.mock.MockTeam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by abadinka.
 */
public class MockDataProvider implements DataProvider {

    private static List<Club> clubs = new ArrayList<>();

    static {
        for (int i = 0; i < 10; i++) {
            List<Team> teams = new ArrayList<>(3);
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

                MockTeam mockTeam = new MockTeam(j, players);

                teams.add(mockTeam);
            }

            MockClub mockClub = new MockClub(teams);
            clubs.add(mockClub);
        }
    }

    @Override
    public List<Club> getClubs() {
        return clubs;
    }
}

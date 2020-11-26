package sk.badand.mafuti.data;

import sk.badand.mafuti.data.mock.MockClub;
import sk.badand.mafuti.data.mock.MockPlayer;
import sk.badand.mafuti.data.mock.MockStaff;
import sk.badand.mafuti.data.mock.MockTeam;
import sk.badand.mafuti.model.Club;
import sk.badand.mafuti.model.Staff;
import sk.badand.mafuti.model.club.Team;
import sk.badand.mafuti.model.common.Nation;
import sk.badand.mafuti.model.league.League;
import sk.badand.mafuti.model.league.LeagueLevel;
import sk.badand.mafuti.model.league.LeagueSystem;
import sk.badand.mafuti.model.match.Player;
import sk.badand.mafuti.model.match.PlayerPosition;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by abadinka.
 */
public class MockDataProvider implements DataProvider {

    private static final Logger LOG = Logger.getLogger(MockDataProvider.class.getName());

    private static final List<Nation> nations = new ArrayList<>();

    private static final List<LeagueSystem> leagueSystems = new ArrayList<>();

    private static final List<Club> clubs = new ArrayList<>();

    static {
        LOG.fine("Generating countries...");
        int i = 1;
        for (String country : Locale.getISOCountries()) {
            Locale locale = new Locale("", country);
            Nation nation = new Nation(locale.getISO3Country(), locale.getDisplayCountry());
            nations.add(nation);
            League league1 = new League(10000 + i, nation.country + " league " + 1, null);
            League league2 = new League(11000 + i, nation.country + " league " + 2, null);
            List<Club> clubs1 = generateClubs(12, league1);
            List<Club> clubs2 = generateClubs(6, league2);

            leagueSystems.add(new LeagueSystem(i++, nation, Stream.of(
                    new LeagueLevel(1000 + i, (byte) 2, Stream.of(
                            league1
                    ).collect(toList())),
                    new LeagueLevel(1100 + i, (byte) 2, Stream.of(
                            league2
                    ).collect(toList()))
            ).collect(toList())));
            clubs.addAll(clubs1);
            clubs.addAll(clubs2);
        }
        LOG.log(Level.FINE, "Done. Created {0} nations", nations.size());
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

    @Override
    public List<Team> getTeams(League league) {
        return league.getTeams(); //FIXME ?? wtf
    }

    @Override
    public List<Club> getClubs() {
        return clubs;
    }

    @Override
    public List<Player> getPlayers() {
        return new ArrayList<>();
    }

    @Override
    public List<Nation> getNations() {
        return nations;
    }

    @Override
    public List<LeagueSystem> getLeagueSystems() {
        return leagueSystems;
    }
}

package sk.badand.mafuti.services;

import sk.badand.mafuti.data.Data;
import sk.badand.mafuti.model.common.Nation;
import sk.badand.mafuti.model.league.League;
import sk.badand.mafuti.model.league.LeagueSystem;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by abadinka.
 */
public class LeagueService {
    private final Data data = Data.getInstance();
    private final HashMap<Nation, List<League>> leagues = new HashMap<>();

    public LeagueService() {
        data.getLeagueSystems().stream()
                .forEach(leagueSystem -> {
                    leagues.put(
                            leagueSystem.getNation(),
                            leagueSystem.getLeagueLevels().stream()
                                    .flatMap(level -> level.getLeagues().stream())
                                    .collect(Collectors.toList())
                    );
                });
    }

    public List<LeagueSystem> getLeagueSystems() {
        return data.getLeagueSystems();
    }

    public LeagueSystem getLeagueSystem(Nation nation) {
        return data.getLeagueSystems().parallelStream()
                .filter(leagueSystem -> leagueSystem.getNation().equals(nation))
                .findFirst()
                .get();
    }

    public List<League> getLeagues(Nation nation) {
        return leagues.get(nation);
    }
}

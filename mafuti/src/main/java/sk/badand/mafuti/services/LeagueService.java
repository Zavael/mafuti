package sk.badand.mafuti.services;

import sk.badand.mafuti.model.common.Nation;
import sk.badand.mafuti.model.league.League;
import sk.badand.mafuti.model.league.LeagueSystem;
import sk.badand.mafuti.services.data.Data;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by abadinka.
 */
public class LeagueService {
    private final Data data = Data.getInstance();
    private final HashMap<Nation, List<League>> leagues = new HashMap<>();

    public LeagueService() {
    }

    public List<LeagueSystem> getLeagueSystems() {
        return data.getLeagueSystems();
    }

    public Optional<LeagueSystem> getLeagueSystem(Nation nation) {
        return data.getLeagueSystems().parallelStream()
                .filter(leagueSystem -> leagueSystem.getNation().equals(nation))
                .findFirst();
    }

    public LeagueSystem initOrGetLeagueSystem(Nation forNation) {
        return getLeagueSystem(forNation)
                .orElseGet(() -> {
                    LeagueSystem leagueSystem = new LeagueSystem(forNation.hashCode(), forNation);
                    data.getLeagueSystems().add(leagueSystem);
                    return leagueSystem;
                });
    }

    public List<League> getLeagues(Nation nation) {
        if (leagues.isEmpty()) {
            data.getLeagueSystems().stream()
                    .forEach(leagueSystem -> {
                        leagues.put(
                                leagueSystem.getNation(),
                                leagueSystem.getLeagueLevels().values().stream()
                                        .flatMap(level -> level.getLeagues().stream())
                                        .collect(Collectors.toList())
                        );
                    });
        }
        return leagues.getOrDefault(nation, Collections.emptyList());
    }
}

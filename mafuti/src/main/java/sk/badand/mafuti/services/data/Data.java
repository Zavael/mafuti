package sk.badand.mafuti.services.data;

import lombok.Getter;
import lombok.Setter;
import sk.badand.mafuti.model.Club;
import sk.badand.mafuti.model.Game;
import sk.badand.mafuti.model.common.Nation;
import sk.badand.mafuti.model.league.LeagueLevel;
import sk.badand.mafuti.model.league.LeagueSystem;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Data {
    private static Data data;
    @Getter
    @Setter
    private Game game;

    public static Data getInstance() {
        if (data == null) {
            data = new Data();
        }
        return data;
    }

    public List<LeagueSystem> getLeagueSystems() {
        return game.getLeagueSystems();
    }

    public List<Nation> getNations() {
        return game.getLeagueSystems().stream()
                .map(LeagueSystem::getNation)
                .collect(Collectors.toList());
    }

    public List<Club> getClubs() {
        return getLeagueSystems().stream()
                .map(LeagueSystem::getLeagueLevels)
                .map(HashMap::values)
                .flatMap(Collection::stream)
                .map(LeagueLevel::getLeagues)
                .flatMap(Collection::stream)
                .map(league -> league.getTeams().get(0).getClub())
                .collect(Collectors.toList());
    }
}

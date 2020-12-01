package sk.badand.mafuti.services;

import sk.badand.mafuti.model.Club;
import sk.badand.mafuti.model.club.Team;
import sk.badand.mafuti.model.match.Player;
import sk.badand.mafuti.services.data.Data;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by abadinka.
 */
public class PlayerService {

    private HashMap<Club, List<Player>> playersByClub = new HashMap<>();
    //private HashMap<Team, List<Player>> playersByTeam = new HashMap<>();

    public List<Player> getInjuredPlayers(Club club) {
        List<Club> clubs = Data.getInstance().getClubs();

        return club.getTeams().parallelStream()
                .map(Team::getPlayers)
                .flatMap(Collection::stream)
                .filter(player -> player.isInjured())
                .collect(toList());
    }

    public List<Player> getRoster(Team team) {
        return Collections.emptyList();
    }
}

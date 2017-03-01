package sk.badand.mafuti.services;

import sk.badand.mafuti.data.Data;
import sk.badand.mafuti.model.Club;
import sk.badand.mafuti.model.Team;
import sk.badand.mafuti.model.match.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by abadinka.
 */
public class PlayerService {

    private HashMap<Club, List<Player>> playersByClub = new HashMap<>();
    private HashMap<Team, List<Player>> playersByTeam = new HashMap<>();

    public PlayerService() {
        for(Club club: Data.getClubs()) {
            List<Player> players = new ArrayList<>();
            for(Team team : club.getTeams()) {
                playersByTeam.put(team, team.getPlayers());
                players.addAll(team.getPlayers());
            }
            playersByClub.put(club, players);
        }
    }

    public List<Player> getPlayers(Club club) {
        return playersByClub.get(club);
    }

    public List<Player> getInjuredPlayers(Club club) {
        playersByClub.get(club).stream()
                .forEach(System.out::println);
        return playersByClub.get(club).parallelStream()
                .filter(player -> player.isInjured())
                .collect(toList());
    }

    public List<Player> getRoster(Team team) {
        return Collections.emptyList();
    }

    public List<Player> getSubstitues(Team team) {
        return Collections.emptyList();
    }

    public List<Player> getReserves(Team team) {
        return Collections.emptyList();
    }


}

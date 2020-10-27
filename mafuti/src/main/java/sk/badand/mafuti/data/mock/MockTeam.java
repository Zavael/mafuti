/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.data.mock;

import sk.badand.mafuti.model.Club;
import sk.badand.mafuti.model.club.Team;
import sk.badand.mafuti.model.match.Player;
import sk.badand.math.EmpiricDecider;
import sk.badand.text.StrGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author abadinka
 */
public class MockTeam extends Team {

    public MockTeam(Club club, short priority, List<Player> players) {
        super(club,
                UUID.randomUUID(),
                new StrGenerator().generateDesignation(12) + " FC",
                priority,
                players
        );
    }

    public Player getRandomScorer() {
        Map<Player, Double> options = new HashMap();
        players.forEach(player -> options.put(player, player.scoreProbability()));
        EmpiricDecider<Player> ed = new EmpiricDecider<>(options);
        return ed.getSuccessfulOption();
    }

    public Player getRandomAssistant() {
        Map<Player, Double> options = new HashMap();
        getPlayers()
                .forEach(player -> options.put(player, player.assistProbability()));
        EmpiricDecider<Player> ed = new EmpiricDecider<>(options);
        return ed.getSuccessfulOption();
    }
}

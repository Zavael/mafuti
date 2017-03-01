/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.model;

import sk.badand.mafuti.model.match.Player;
import sk.badand.mafuti.model.match.PlayingTeam;
import sk.badand.mafuti.model.tactic.*;
import sk.badand.math.EmpiricDecider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author abadinka
 */
public class Team implements PlayingTeam {
    private final Object key;
    protected final int overalStrength; //TODO generate dynamicaly
    protected final List<Player> players;
    private final String teamName;
    protected short priority;

    public Team(Object key, String teamName, short priority, List<Player> players) {
        this.key = key;
        this.teamName = teamName;
        this.players = players;
        this.priority = priority;
        overalStrength = players.stream()
                .mapToInt(Player::overallRating)
                .sum();
    }

    @Override
    public String getNameShort() {
        return teamName;
    }

    @Override
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * the lesser is number the more is team prioritized, 0 for A-team etc.
     * @return
     */
    public short getPriority() {
        return priority;
    }

    @Override
    public Optional<Tackling> predefTackling() {
        return Optional.of(Tackling.EASY);
    }

    @Override
    public Optional<Marking> predefMarking() {
        return Optional.empty();
    }

    @Override
    public Optional<CounterAttacks> predefCounterAttacks() {
        return Optional.empty();
    }

    @Override
    public Optional<PassingFocus> predefPassingFocus() {
        return Optional.empty();
    }

    @Override
    public Optional<Philosophy> predefPhilosophy() {
        return Optional.empty();
    }

    @Override
    public Optional<PassingStyle> predefPassingStyle() {
        return Optional.empty();
    }

    @Override
    public int strengthOveral() {
        return overalStrength;
    }

    @Override
    public int strengthInFront() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int strengthInMidfield() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int strengthInBack() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Player getRandomScorer() {
        Map<Player, Double> options = new HashMap();
        getPlayers()
                .forEach(player -> options.put(player, player.scoreProbability()));
        EmpiricDecider<Player> ed = new EmpiricDecider<>(options);
        return ed.getSuccessfulOption();
    }

    @Override
    public Player getRandomAssistant() {
        Map<Player, Double> options = new HashMap();
        getPlayers()
                .forEach(player -> options.put(player, player.assistProbability()));
        EmpiricDecider<Player> ed = new EmpiricDecider<>(options);
        return ed.getSuccessfulOption();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        return key.equals(team.key);
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }
}

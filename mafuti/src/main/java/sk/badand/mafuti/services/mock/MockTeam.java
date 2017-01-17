/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.services.mock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import sk.badand.mafuti.model.match.Player;
import sk.badand.mafuti.model.match.PlayerPosition;
import sk.badand.mafuti.model.match.PlayingTeam;
import sk.badand.mafuti.model.tactic.CounterAttacks;
import sk.badand.mafuti.model.tactic.Marking;
import sk.badand.mafuti.model.tactic.PassingFocus;
import sk.badand.mafuti.model.tactic.PassingStyle;
import sk.badand.mafuti.model.tactic.Philosophy;
import sk.badand.mafuti.model.tactic.Tackling;
import sk.badand.mafuti.model.match.PlayableStadium;
import sk.badand.math.EmpiricDecider;
import sk.badand.text.StrGenerator;

/**
 *
 * @author abadinka
 */
public class MockTeam implements PlayingTeam {

    private final String teamName = new StrGenerator().generateDesignation(12) + " FC";
    private final int overalStrength;
    private final List<Player> players;
    private short priority;

    public MockTeam(short priority) {
        this.priority = priority;
        players = Stream.of(
                new MockPlayer(PlayerPosition.STRIKER),
                new MockPlayer(PlayerPosition.STRIKER),
                new MockPlayer(PlayerPosition.WINGER),
                new MockPlayer(PlayerPosition.WINGER),
                new MockPlayer(PlayerPosition.MIDFIELDER),
                new MockPlayer(PlayerPosition.MIDFIELDER),
                new MockPlayer(PlayerPosition.WINGBACK),
                new MockPlayer(PlayerPosition.WINGBACK),
                new MockPlayer(PlayerPosition.DEFENDER),
                new MockPlayer(PlayerPosition.DEFENDER),
                new MockPlayer(PlayerPosition.GOALKEEPER))
                .collect(Collectors.toList());
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

    @Override
    public short getPriority() {
        return priority;
    }

    @Override
    public PlayableStadium getStadium() {
        return new MockStadium();
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
        getPlayers().stream()
                .forEach(player -> options.put(player, player.scoreProbability()));
        EmpiricDecider<Player> ed = new EmpiricDecider<>(options);
        return ed.getSuccessfulOption();
    }

    @Override
    public Player getRandomAssistant() {
        Map<Player, Double> options = new HashMap();
        getPlayers().stream()
                .forEach(player -> options.put(player, player.assistProbability()));
        EmpiricDecider<Player> ed = new EmpiricDecider<>(options);
        return ed.getSuccessfulOption();
    }

    private static class MockStadium implements PlayableStadium {

        private final String stadiumName = new StrGenerator().generateDesignation(8) + " stadium";

        public MockStadium() {
        }

        @Override
        public String getName() {
            return stadiumName;
        }
    }

}

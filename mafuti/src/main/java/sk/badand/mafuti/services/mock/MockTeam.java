/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.services.mock;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import sk.badand.mafuti.model.tactic.CounterAttacks;
import sk.badand.mafuti.model.tactic.Marking;
import sk.badand.mafuti.model.tactic.PassingFocus;
import sk.badand.mafuti.model.tactic.PassingStyle;
import sk.badand.mafuti.model.tactic.Philosophy;
import sk.badand.mafuti.model.tactic.Tackling;
import sk.badand.mafuti.services.PlayableStadium;
import sk.badand.mafuti.services.PlayableTeam;
import sk.badand.mafuti.services.Player;
import sk.badand.text.StrGenerator;

/**
 *
 * @author abadinka
 */
public class MockTeam implements PlayableTeam {

    private final String teamName = new StrGenerator().generateDesignation(12) + " FC";

    public MockTeam() {
    }

    @Override
    public String getNameShort() {
        return teamName;
    }

    @Override
    public List<Player> getPlayers() {
        return Stream.of(
                new MockPlayer(),
                new MockPlayer(),
                new MockPlayer(),
                new MockPlayer(),
                new MockPlayer(),
                new MockPlayer(),
                new MockPlayer(),
                new MockPlayer(),
                new MockPlayer(),
                new MockPlayer(),
                new MockPlayer(),
                new MockPlayer(),
                new MockPlayer()).
                collect(Collectors.toList());
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

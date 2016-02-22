/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.services.mock;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import sk.badand.mafuti.services.PlayableStadium;
import sk.badand.mafuti.services.PlayableTeam;
import sk.badand.mafuti.services.Player;
import sk.badand.text.StrGenerator;

/**
 *
 * @author abadinka
 */
public class MockTeam implements PlayableTeam {

    public MockTeam() {
    }

    @Override
    public String getNameShort() {
        return new StrGenerator().generateDesignation(12) + " FC";
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

    private static class MockStadium implements PlayableStadium {

        public MockStadium() {
        }

        @Override
        public String getName() {
            return new StrGenerator().generateDesignation(8) + " stadium";
        }
    }

}

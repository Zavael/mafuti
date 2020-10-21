/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.data.mock;

import sk.badand.mafuti.model.Team;
import sk.badand.mafuti.model.match.Player;
import sk.badand.text.StrGenerator;

import java.util.List;

/**
 * @author abadinka
 */
public class MockTeam extends Team {

    public MockTeam(short priority, List<Player> players) {
        super(new String("team"),
                new StrGenerator().generateDesignation(12) + " FC",
                priority,
                players
        );
    }
}

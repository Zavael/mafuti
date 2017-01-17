/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.model;

import sk.badand.mafuti.model.match.PlayableStadium;
import sk.badand.mafuti.model.match.Player;
import sk.badand.mafuti.model.tactic.*;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author abadinka
 */
public interface Team {

    String getNameShort();

    PlayableStadium getStadium();

    List<Player> getPlayers();

    short getPriority(); // the lesser is number the more is team prioritized, 0 for A-team etc.

    Optional<CounterAttacks> predefCounterAttacks();

    Optional<Marking> predefMarking();

    Optional<PassingFocus> predefPassingFocus();

    Optional<PassingStyle> predefPassingStyle();

    Optional<Philosophy> predefPhilosophy();

    Optional<Tackling> predefTackling();
}

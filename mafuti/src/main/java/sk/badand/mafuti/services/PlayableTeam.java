/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.services;

import java.util.List;
import java.util.Optional;
import sk.badand.mafuti.model.tactic.CounterAttacks;
import sk.badand.mafuti.model.tactic.Marking;
import sk.badand.mafuti.model.tactic.PassingFocus;
import sk.badand.mafuti.model.tactic.PassingStyle;
import sk.badand.mafuti.model.tactic.Philosophy;
import sk.badand.mafuti.model.tactic.Tackling;

/**
 *
 * @author abadinka
 */
public interface PlayableTeam {

    public String getNameShort();

    public List<Player> getPlayers();

    public PlayableStadium getStadium();
    
    public Optional<Tackling> predefTackling();

    public Optional<Marking> predefMarking();

    public Optional<CounterAttacks> predefCounterAttacks();

    public Optional<PassingFocus> predefPassingFocus();

    public Optional<Philosophy> predefPhilosophy();

    public Optional<PassingStyle> predefPassingStyle();
    
}

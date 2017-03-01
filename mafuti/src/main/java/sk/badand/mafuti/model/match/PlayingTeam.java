/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.model.match;

import sk.badand.mafuti.model.tactic.*;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author abadinka
 */
public interface PlayingTeam{

    String getNameShort();

    List<Player> getPlayers();

    Optional<Tackling> predefTackling();

    Optional<Marking> predefMarking();

    Optional<CounterAttacks> predefCounterAttacks();

    Optional<PassingFocus> predefPassingFocus();

    Optional<Philosophy> predefPhilosophy();

    Optional<PassingStyle> predefPassingStyle();

    /**
     * ranges from ~(180 - 450)
     * @return 
     */
    int strengthOveral();
    
    int strengthInFront();
    
    int strengthInMidfield();
    
    int strengthInBack();


    Player getRandomScorer();
    
    Player getRandomAssistant();
}

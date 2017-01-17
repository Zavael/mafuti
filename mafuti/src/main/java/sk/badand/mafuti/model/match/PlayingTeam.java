/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.model.match;

import sk.badand.mafuti.model.Team;
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
public interface PlayingTeam extends Team {

    /**
     * ranges from ~(180 - 450)
     * @return 
     */
    public int strengthOveral();
    
    public int strengthInFront();
    
    public int strengthInMidfield();
    
    public int strengthInBack();


    Player getRandomScorer();
    
    Player getRandomAssistant();
}

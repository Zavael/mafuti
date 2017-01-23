/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.model.match;

import sk.badand.mafuti.model.Team;

/**
 *
 * @author abadinka
 */
public interface PlayingTeam extends Team {

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

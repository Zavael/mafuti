/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.services;

import java.util.List;

/**
 *
 * @author abadinka
 */
public interface PlayableTeam {

    public String getNameShort();

    public List<Player> getPlayers();

    public PlayableStadium getStadium();
    
}

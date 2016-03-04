/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.services;

/**
 *
 * @author abadinka
 */
public interface Result {

    public String getAwayTeamName();

    public String getHomeTeamName();

    public int homeShots();

    public int awayShots();

    public int homeCorners();

    public int awayCorners();

    public int homeFreekicks();

    public int awayFreekicks();

    public int homeFouls();

    public int awayFouls();
    
}

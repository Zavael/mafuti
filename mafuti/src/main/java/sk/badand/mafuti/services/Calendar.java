/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import sk.badand.mafuti.model.Team;
import sk.badand.mafuti.model.match.Match;

/**
 *
 * @author abadinka
 */
class Calendar {
    
    // duplicating different matches ordering
    private Map<LocalDate, List<Match>> matchesByDate;
    private Map<Team, List<Match>> matchesByTeam;
    
    // subclassing to future calendar + historical calendar?
}

package sk.badand.mafuti.model.league;

import lombok.Data;
import lombok.EqualsAndHashCode;
import sk.badand.mafuti.model.common.Nation;

import java.io.Serializable;
import java.util.HashMap;

@Data
public class LeagueSystem implements Serializable {

    private static final long serialVersionUID = 5620175648215622730L;
    private final int id;
    @EqualsAndHashCode.Exclude
    private final Nation nation;
    @EqualsAndHashCode.Exclude
    private final HashMap<Integer, LeagueLevel> leagueLevels = new HashMap<>(); //TODO consider HashMap<LeagueLevel, Collection<Leagues>>
}

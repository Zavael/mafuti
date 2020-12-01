package sk.badand.mafuti.model;

import lombok.Data;
import sk.badand.mafuti.model.league.LeagueSystem;

import java.io.Serializable;
import java.util.List;

@Data
public class Game implements Serializable {
    private static final long serialVersionUID = -7210622339504703906L;
    private final List<LeagueSystem> leagueSystems;
}

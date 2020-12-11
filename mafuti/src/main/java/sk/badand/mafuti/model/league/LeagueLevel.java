package sk.badand.mafuti.model.league;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by abadinka.
 */
@Data
public class LeagueLevel implements Serializable {

    private static final long serialVersionUID = -629534549716249973L;
    @Getter
    private final int id;
    private final byte promotedCount;
    private final List<League> leagues;
}

package sk.badand.mafuti.model;

import java.util.List;

/**
 * Created by abadinka.
 */
public interface Club {

    List<Team> getTeams();

    Budget getBudget();

    Manager getManager();
}

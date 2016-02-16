/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.world;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import sk.badand.mafuti.ui.navigation.AbstractNavigator;
import sk.badand.mafuti.ui.world.competitions.CompetitionsView;
import sk.badand.mafuti.ui.world.jobs.JobsView;
import sk.badand.mafuti.ui.world.search.SearchView;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class WorldPresenter extends AbstractNavigator {

    private static final Logger LOG = Logger.getLogger(WorldPresenter.class.getName());

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showCompetitions();
    }

    public void showCompetitions() {
        LOG.log(Level.FINE, "showCompetitions");
        setContent(new CompetitionsView());
    }

    public void showStatistics() {
        LOG.log(Level.FINE, "showStatistics");//TODO rethink, maybe include in competitions somehow
    }

    public void showJobs() {
        LOG.log(Level.FINE, "showJobs");
        setContent(new JobsView());
    }

    public void showSearch() {
        LOG.log(Level.FINE, "showSearch");
        setContent(new SearchView());
    }
}

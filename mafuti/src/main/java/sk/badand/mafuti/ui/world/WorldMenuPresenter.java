/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.world;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import sk.badand.mafuti.ui.navigation.AbstractNavigator;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class WorldMenuPresenter extends AbstractNavigator {
    private static final Logger LOG = Logger.getLogger(WorldMenuPresenter.class.getName());

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void showCompetitions() {
        LOG.log(Level.INFO, "showCompetitions");
    }
    
    public void showStatistics() {
        LOG.log(Level.INFO, "showStatistics");//TODO rethink, maybe include in competitions somehow
    }
    
    public void showJobs() {
        LOG.log(Level.INFO, "showJobs");
    }
    
    public void showSearch() {
        LOG.log(Level.INFO, "showSearch");
    }
    
}

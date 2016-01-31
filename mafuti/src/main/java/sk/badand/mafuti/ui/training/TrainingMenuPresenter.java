/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.training;

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
public class TrainingMenuPresenter extends AbstractNavigator {
    private static final Logger LOG = Logger.getLogger(TrainingMenuPresenter.class.getName());

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void showPlayers() {
        LOG.log(Level.INFO, "showPlayers");
    }

    public void showOnRehab() {
        LOG.log(Level.INFO, "showOnRehab");
    }

    public void showPrograms() {
        LOG.log(Level.INFO, "showPrograms");
    }
}

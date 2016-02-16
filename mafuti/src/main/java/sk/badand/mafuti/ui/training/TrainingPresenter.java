/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.training;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import sk.badand.mafuti.ui.navigation.AbstractNavigator;
import sk.badand.mafuti.ui.training.players.PlayersView;
import sk.badand.mafuti.ui.training.programs.ProgramsView;
import sk.badand.mafuti.ui.training.rehab.RehabView;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class TrainingPresenter extends AbstractNavigator {

    private static final Logger LOG = Logger.getLogger(TrainingPresenter.class.getName());

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showPlayers();
    }

    public void showPlayers() {
        LOG.log(Level.FINE, "showPlayers");
        setContent(new PlayersView());
    }

    public void showOnRehab() {
        LOG.log(Level.FINE, "showOnRehab");
        setContent(new RehabView());
    }

    public void showPrograms() {
        LOG.log(Level.FINE, "showPrograms");
        setContent(new ProgramsView());
    }
}

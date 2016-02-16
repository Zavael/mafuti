/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.intro;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import sk.badand.mafuti.ui.dashboard.DashboardView;
import sk.badand.mafuti.ui.navigation.AbstractNavigator;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class IntroPresenter extends AbstractNavigator {
    private static final Logger LOG = Logger.getLogger(IntroPresenter.class.getName());

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void continueGame() {
        LOG.log(Level.FINE, "continueGame");
        navigator.load(new DashboardView());
    }

    public void newGame() {
        LOG.log(Level.FINE, "newGame");
    }

    public void loadGame() {
        LOG.log(Level.FINE, "loadGame");
    }

    public void exitGame() {
        LOG.log(Level.FINE, "exitGame");
    }

    public void verifyAccount() {
        LOG.log(Level.FINE, "verifyAccount");
    }
}

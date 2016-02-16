/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.postmatch;

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
public class PostmatchPresenter extends AbstractNavigator {
    private static final Logger LOG = Logger.getLogger(PostmatchPresenter.class.getName());

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void showDashboard() {
        LOG.log(Level.FINE, "showDashboard");
        navigator.load(new DashboardView());
    }
}

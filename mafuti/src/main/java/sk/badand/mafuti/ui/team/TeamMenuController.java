/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.team;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import sk.badand.mafuti.ui.navigation.AbstractNavigator;
import sk.badand.mafuti.util.Navigator;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class TeamMenuController extends AbstractNavigator {

    private static final Logger LOG = Logger.getLogger(TeamMenuController.class.getName());

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void showATeam() {
        LOG.log(Level.INFO, "showATeam");
    }

    public void showBTeam() {
        LOG.log(Level.INFO, "showBTeam");
    }

    public void showYouthTeam() {
        LOG.log(Level.INFO, "showYouthTeam");
    }

    public void showStaff() {
        LOG.log(Level.INFO, "showStaff");
    }
}

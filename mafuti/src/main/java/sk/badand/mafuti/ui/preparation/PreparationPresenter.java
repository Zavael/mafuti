/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.preparation;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import sk.badand.mafuti.ui.match.MatchView;
import sk.badand.mafuti.ui.navigation.AbstractNavigator;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class PreparationPresenter extends AbstractNavigator {

    private static final Logger LOG = Logger.getLogger(PreparationPresenter.class.getName());

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void showMatch() {
        LOG.log(Level.FINE, "showMatch");
        navigator.load(new MatchView());
    }
}

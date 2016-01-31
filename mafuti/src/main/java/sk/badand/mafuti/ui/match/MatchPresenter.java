/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.match;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import sk.badand.mafuti.ui.navigation.AbstractNavigator;
import sk.badand.mafuti.ui.postmatch.PostmatchView;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class MatchPresenter extends AbstractNavigator {
    private static final Logger LOG = Logger.getLogger(MatchPresenter.class.getName());

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void showPostmatch() {
        LOG.log(Level.FINE, "showPostmatch");
        navigator.load(new PostmatchView());
    }
    
}

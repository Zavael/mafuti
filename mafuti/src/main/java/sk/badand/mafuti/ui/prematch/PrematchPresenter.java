/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.prematch;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import sk.badand.mafuti.ui.preparation.PreparationView;
import sk.badand.mafuti.ui.navigation.AbstractNavigator;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class PrematchPresenter extends AbstractNavigator {

    private static final Logger LOG = Logger.getLogger(PrematchPresenter.class.getName());

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void showMatchTactic(ActionEvent event) {
        LOG.log(Level.FINE, "showMatchTactic");
        navigator.load(new PreparationView());
    }

}

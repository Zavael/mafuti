/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.training;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import sk.badand.mafuti.ui.navigation.AbstractNavigator;
import sk.badand.mafuti.ui.training.players.PlayersView;
import sk.badand.mafuti.ui.training.rehab.RehabView;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class TrainingPresenter extends AbstractNavigator {

    private static final Logger LOG = Logger.getLogger(TrainingPresenter.class.getName());
    
    @FXML
    Pane content;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        content.getChildren().clear();
        content.getChildren().add(new PlayersView().getView());
    }

    public void showPlayers() {
        LOG.log(Level.FINE, "showPlayers");
        content.getChildren().clear();
        content.getChildren().add(new PlayersView().getView());
    }

    public void showOnRehab() {
        LOG.log(Level.FINE, "showOnRehab");
        content.getChildren().clear();
        content.getChildren().add(new RehabView().getView());
    }

    public void showPrograms() {
        LOG.log(Level.FINE, "showPrograms");
        content.getChildren().clear();
        content.getChildren().add(new Label("coming soon..."));
    }
}

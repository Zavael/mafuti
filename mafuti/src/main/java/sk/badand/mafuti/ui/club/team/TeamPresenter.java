/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.club.team;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import sk.badand.mafuti.ui.club.team.tactics.TacticsView;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class TeamPresenter implements Initializable {

    public static final Logger LOG = Logger.getLogger(TeamPresenter.class.getName());
    public Pane tabTactics;

    @FXML
    Label title;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TacticsView tacticsView = new TacticsView();

        tabTactics.getChildren().add(tacticsView.getView());
        // TODO
    }    
    
    public void setTitle(String titleToSet) {
        title.setText(titleToSet);
    }
    
}

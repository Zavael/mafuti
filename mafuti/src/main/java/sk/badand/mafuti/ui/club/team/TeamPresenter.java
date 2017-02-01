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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import sk.badand.mafuti.ui.club.team.formation.FormationView;
import sk.badand.mafuti.ui.club.team.tactics.TacticsView;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class TeamPresenter implements Initializable {

    public static final Logger LOG = Logger.getLogger(TeamPresenter.class.getName());
    public Pane tabTactics;
    public Pane tabFormation;

    @FXML
    Label title;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabTactics.getChildren().add(new TacticsView().getView());
        tabFormation.getChildren().add(new FormationView().getView());
    }    
    
    public void setTitle(String titleToSet) {
        title.setText(titleToSet);
    }
    
}

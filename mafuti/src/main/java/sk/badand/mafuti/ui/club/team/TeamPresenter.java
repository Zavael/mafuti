/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.club.team;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import sk.badand.mafuti.model.Team;
import sk.badand.mafuti.ui.club.team.formation.FormationView;
import sk.badand.mafuti.ui.club.team.players.PlayersPresenter;
import sk.badand.mafuti.ui.club.team.players.PlayersView;
import sk.badand.mafuti.ui.club.team.tactics.TacticsView;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class TeamPresenter implements Initializable {

    public static final Logger LOG = Logger.getLogger(TeamPresenter.class.getName());
    public Pane tabTactics;
    public Pane tabFormation;
    public Pane tabPlayers;

    private PlayersPresenter playersPresenter;

    @FXML
    Label title;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabTactics.getChildren().add(new TacticsView().getView());
        tabFormation.getChildren().add(new FormationView().getView());
        PlayersView playersView = new PlayersView();
        playersPresenter = (PlayersPresenter) playersView.getPresenter();
        tabPlayers.getChildren().add(playersView.getView());
    }

    public void setTitle(String titleToSet) {
        title.setText(titleToSet);
    }
    public void setTeam(Team team) {
        playersPresenter.setPlayers(team.getPlayers());
    }
}

/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.club;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import sk.badand.mafuti.ui.club.staff.StaffView;
import sk.badand.mafuti.ui.club.team.TeamPresenter;
import sk.badand.mafuti.ui.club.team.TeamView;
import sk.badand.mafuti.ui.navigation.AbstractNavigator;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class ClubPresenter extends AbstractNavigator {

    private static final Logger LOG = Logger.getLogger(ClubPresenter.class.getName());

    @FXML
    Pane content;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        content.getChildren().clear();
        final TeamView teamView = new TeamView();
        ((TeamPresenter) teamView.getPresenter()).setTitle("a-team");
        content.getChildren().add(teamView.getView());
    }

    public void showATeam() {
        content.getChildren().clear();
        final TeamView teamView = new TeamView();
        ((TeamPresenter) teamView.getPresenter()).setTitle("a-team");
        content.getChildren().add(teamView.getView());
    }

    public void showBTeam() {
        content.getChildren().clear();
        final TeamView teamView = new TeamView();
        ((TeamPresenter) teamView.getPresenter()).setTitle("b-team");
        content.getChildren().add(teamView.getView());
    }

    public void showYouthTeam() {
        content.getChildren().clear();
        final TeamView teamView = new TeamView();
        ((TeamPresenter) teamView.getPresenter()).setTitle("youth-team");
        content.getChildren().add(teamView.getView());
    }

    public void showStaff() {
        content.getChildren().clear();
        content.getChildren().add(new StaffView().getView());
    }
}

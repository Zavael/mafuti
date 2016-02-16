/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.club;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showATeam();
    }

    public void showATeam() {
        LOG.log(Level.FINE, "showATeam");
        final TeamView teamView = new TeamView();
        ((TeamPresenter) teamView.getPresenter()).setTitle("a-team");
        setContent(teamView);
    }

    public void showBTeam() {
        LOG.log(Level.FINE, "showBTeam");
        final TeamView teamView = new TeamView();
        ((TeamPresenter) teamView.getPresenter()).setTitle("b-team");
        setContent(teamView);
    }

    public void showYouthTeam() {
        LOG.log(Level.FINE, "showYouthTeam");
        final TeamView teamView = new TeamView();
        ((TeamPresenter) teamView.getPresenter()).setTitle("youth-team");
        setContent(teamView);
    }

    public void showStaff() {
        LOG.log(Level.FINE, "showStaff");
        setContent(new StaffView());
    }
}

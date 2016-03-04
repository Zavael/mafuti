/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.postmatch;

import com.airhacks.afterburner.injection.Injector;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javax.inject.Inject;
import sk.badand.mafuti.services.Player;
import sk.badand.mafuti.services.Result;
import sk.badand.mafuti.services.mock.MockPlayer;
import sk.badand.mafuti.ui.dashboard.DashboardView;
import sk.badand.mafuti.ui.navigation.AbstractNavigator;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class PostmatchPresenter extends AbstractNavigator {
    private static final Logger LOG = Logger.getLogger(PostmatchPresenter.class.getName());

    @Inject
    private Result matchResult;
    @FXML
    private Label homeTeamName;
    @FXML
    private Label awayTeamName;
    @FXML
    private Label homeShots;
    @FXML
    private Label awayShots;
    @FXML
    private Label homeCorners;
    @FXML
    private Label awayCorners;
    @FXML
    private Label homeFreekicks;
    @FXML
    private Label awayFreekicks;
    @FXML
    private Label homeFouls;
    @FXML
    private Label awayFouls;
    @FXML
    private ListView<Player> homeBestPlayers;
    @FXML
    private ListView<Player> awayBestPlayers;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initControls();
    }

    private void initControls() {
        // TODO
        homeTeamName.setText(matchResult.getHomeTeamName());
        awayTeamName.setText(matchResult.getAwayTeamName());
        homeBestPlayers.getItems().add(new MockPlayer());
        homeBestPlayers.getItems().add(new MockPlayer());
        homeBestPlayers.getItems().add(new MockPlayer());
        awayBestPlayers.getItems().add(new MockPlayer());
        awayBestPlayers.getItems().add(new MockPlayer());
        awayBestPlayers.getItems().add(new MockPlayer());
        homeShots.setText(String.valueOf(matchResult.homeShots()));
        awayShots.setText(String.valueOf(matchResult.awayShots()));
        homeCorners.setText(String.valueOf(matchResult.homeCorners()));
        awayCorners.setText(String.valueOf(matchResult.awayCorners()));
        homeFreekicks.setText(String.valueOf(matchResult.homeFreekicks()));
        awayFreekicks.setText(String.valueOf(matchResult.awayFreekicks()));
        homeFouls.setText(String.valueOf(matchResult.homeFouls()));
        awayFouls.setText(String.valueOf(matchResult.awayFouls()));
    }

    @Override
    public void showDashboard() {
        LOG.log(Level.FINE, "showDashboard");
        Injector.setModelOrService(Result.class, null);
        navigator.load(new DashboardView());
    }
}

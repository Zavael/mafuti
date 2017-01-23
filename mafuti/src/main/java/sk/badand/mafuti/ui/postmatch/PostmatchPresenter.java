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

import sk.badand.mafuti.model.match.PlayableMatch;
import sk.badand.mafuti.model.match.PlayerStatistics;
import sk.badand.mafuti.model.match.result.Result;
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
    Label homeGoals;
    @FXML
    Label awayGoals;
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
    private ListView<PlayerStatistics> homeBestPlayers;
    @FXML
    private ListView<PlayerStatistics> awayBestPlayers;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initControls();
    }

    private void initControls() {
        // TODO
        homeGoals.setText(String.valueOf(matchResult.getHomeGoals()));
        awayGoals.setText(String.valueOf(matchResult.getAwayGoals()));
        homeTeamName.setText(matchResult.getHomeTeamName());
        awayTeamName.setText(matchResult.getAwayTeamName());
        homeBestPlayers.getItems().addAll(matchResult.homeBestPlayers());
        awayBestPlayers.getItems().addAll(matchResult.awayBestPlayers());
        homeShots.setText(String.valueOf(matchResult.getHomeTeamStatistics().getShotsOnTarget()));
        awayShots.setText(String.valueOf(matchResult.getAwayTeamStatistics().getShotsOnTarget()));
        homeCorners.setText(String.valueOf(matchResult.getHomeTeamStatistics().getCorners()));
        awayCorners.setText(String.valueOf(matchResult.getAwayTeamStatistics().getCorners()));
        homeFreekicks.setText(String.valueOf(matchResult.getHomeTeamStatistics().getFreeKicks()));
        awayFreekicks.setText(String.valueOf(matchResult.getAwayTeamStatistics().getFreeKicks()));
        homeFouls.setText(String.valueOf(matchResult.getHomeTeamStatistics().getFouls()));
        awayFouls.setText(String.valueOf(matchResult.getAwayTeamStatistics().getFouls()));
    }

    @Override
    public void showDashboard() {
        LOG.log(Level.FINE, "showDashboard");
        Injector.setModelOrService(Result.class, null);
        Injector.setModelOrService(PlayableMatch.class, null);
        navigator.load(new DashboardView());
    }
}

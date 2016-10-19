/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.prematch;

import com.airhacks.afterburner.injection.Injector;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javax.inject.Inject;
import sk.badand.mafuti.model.match.Player;
import sk.badand.mafuti.model.match.PlayingTeam;
import sk.badand.mafuti.model.match.PlayableMatch;
import sk.badand.mafuti.ui.preparation.PreparationView;
import sk.badand.mafuti.ui.navigation.AbstractNavigator;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class PrematchPresenter extends AbstractNavigator {

    private static final Logger LOG = Logger.getLogger(PrematchPresenter.class.getName());
    @Inject
    private PlayableMatch match;

    @FXML
    private Label stadiumName;
    @FXML
    private Label attendance;
    @FXML
    private Label playDate;
    @FXML
    private Label playTime;
    @FXML
    private Label weather;
    @FXML
    private Label homeTeamName;
    @FXML
    private Label awayTeamName;
    @FXML
    private ListView<Player> homeKeyPlayers;
    @FXML
    private ListView<Player> awayKeyPlayers;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initControls(match);
    }

    @FXML
    public void showMatchTactic(ActionEvent event) {
        LOG.log(Level.FINE, "showMatchTactic");
        
        Injector.setModelOrService(PlayingTeam.class, match.getManagerTeam());
        
        navigator.load(new PreparationView());
    }

    private void initControls(PlayableMatch match) {
        LOG.log(Level.FINE, "match: {0}", match);
        homeTeamName.setText(match.getHomeTeamName());
        awayTeamName.setText(match.getAwayTeamName());
        homeKeyPlayers.getItems().addAll(match.getHomeTop5Players());
        awayKeyPlayers.getItems().addAll(match.getAwayTop5Players());

        stadiumName.setText(match.getStadiumName());
        attendance.setText(match.getAttendance());
        playDate.setText(match.getPlayDate().toString());
        playTime.setText(match.getPlayTime());
        weather.setText(match.getWeather().toString());
    }
}

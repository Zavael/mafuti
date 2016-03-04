/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.match;

import com.airhacks.afterburner.injection.Injector;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javax.inject.Inject;
import sk.badand.mafuti.services.PlayableMatch;
import sk.badand.mafuti.services.Result;
import sk.badand.mafuti.services.mock.MockResult;
import sk.badand.mafuti.ui.navigation.AbstractNavigator;
import sk.badand.mafuti.ui.postmatch.PostmatchView;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class MatchPresenter extends AbstractNavigator {

    private static final Logger LOG = Logger.getLogger(MatchPresenter.class.getName());

    @Inject
    private PlayableMatch match;

    @FXML
    Label homeGoals;
    @FXML
    Label awayGoals;
    @FXML
    Label playTime;
    @FXML
    private Label homeTeamName;
    @FXML
    private Label awayTeamName;
    @FXML
    private Button startMatch;
    @FXML
    private Button next;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        homeGoals.setText("4");
        awayGoals.setText("2");
        playTime.setText("99:99");
        homeTeamName.setText(match.getHomeTeamName());
        awayTeamName.setText(match.getAwayTeamName());
    }

    public void showPostmatch() {
        LOG.log(Level.FINE, "showPostmatch");
        match.play();
        Injector.setModelOrService(PlayableMatch.class, null);
        Injector.setModelOrService(Result.class, match.result());
        navigator.load(new PostmatchView());
    }

    public void startMatch() {
        LOG.log(Level.FINE, "startMatch");
        startMatch.setDisable(true);
        
        next.setDisable(false);
    }
}

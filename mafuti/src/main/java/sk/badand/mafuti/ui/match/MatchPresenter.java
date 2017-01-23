/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.match;

import com.airhacks.afterburner.injection.Injector;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javax.inject.Inject;
import sk.badand.mafuti.model.match.PlayableMatch;
import sk.badand.mafuti.model.match.result.Result;
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

    private SimpleObjectProperty<Result> result = new SimpleObjectProperty<>();

    @FXML
    Label homeGoals;
    @FXML
    Label awayGoals;
    @FXML
    Label playTime;
    @FXML
    private Label homeTeamName;
    @FXML
    private ListView homePlayerEvents;
    @FXML
    private ListView awayPlayerEvents;
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
        homeGoals.setText("0");
        awayGoals.setText("0");
        playTime.setText("00:00");
        homeTeamName.setText(match.getHomeTeamName());
        awayTeamName.setText(match.getAwayTeamName());

        result.addListener((res, oldV, newV) -> {
            if (newV != null) {
                homeGoals.setText(String.valueOf(newV.getHomeGoals()));
                awayGoals.setText(String.valueOf(newV.getAwayGoals()));
                homePlayerEvents.getItems().addAll(newV.homePlayerStats());
                awayPlayerEvents.getItems().addAll(newV.awayPlayerStats());
            }
            playTime.setText("90:00");
        });
    }

    public void showPostmatch() {
        LOG.log(Level.FINE, "showPostmatch");
        Injector.setModelOrService(Result.class, match.result());
        navigator.load(new PostmatchView());
    }

    public void startMatch() {
        LOG.log(Level.FINE, "startMatch");
        startMatch.setDisable(true);

        match.play();
        result.set(match.result());

        next.setDisable(false);
    }
}

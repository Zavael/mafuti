/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.preparation;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javax.inject.Inject;
import sk.badand.mafuti.model.tactic.CounterAttacks;
import sk.badand.mafuti.model.tactic.Marking;
import sk.badand.mafuti.model.tactic.PassingFocus;
import sk.badand.mafuti.model.tactic.PassingStyle;
import sk.badand.mafuti.model.tactic.Philosophy;
import sk.badand.mafuti.model.tactic.Tackling;
import sk.badand.mafuti.services.PlayableTeam;
import sk.badand.mafuti.ui.match.MatchView;
import sk.badand.mafuti.ui.navigation.AbstractNavigator;
import sk.badand.mafuti.ui.postmatch.PostmatchView;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class PreparationPresenter extends AbstractNavigator {

    private static final Logger LOG = Logger.getLogger(PreparationPresenter.class.getName());
    
    @Inject
    PlayableTeam team;
    
    @FXML
    ComboBox<String> markingChoice;
    @FXML
    ComboBox<String> tacklingChoice;
    @FXML
    ComboBox<String> counterAttChoice;
    @FXML
    ComboBox<String> philosophyChoice;
    @FXML
    ComboBox<String> passStyleChoice;
    @FXML
    ComboBox<String> passFocusChoice;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Stream.of(Marking.values())
                .forEach(val -> markingChoice.getItems().add(rb.getString(val.key())));
        markingChoice.setValue(rb.getString(team.predefMarking().orElse(Marking.MAN).key()));
        Stream.of(Tackling.values())
                .forEach(val -> tacklingChoice.getItems().add(rb.getString(val.key())));
        tacklingChoice.setValue(rb.getString(team.predefTackling().orElse(Tackling.NORMAL).key()));
        Stream.of(CounterAttacks.values())
                .forEach(val -> counterAttChoice.getItems().add(rb.getString(val.key())));
        counterAttChoice.setValue(rb.getString(team.predefCounterAttacks().orElse(CounterAttacks.SOMETIMES).key()));
        Stream.of(PassingFocus.values())
                .forEach(val -> passFocusChoice.getItems().add(rb.getString(val.key())));
        passFocusChoice.setValue(rb.getString(team.predefPassingFocus().orElse(PassingFocus.MIXED).key()));
        Stream.of(PassingStyle.values())
                .forEach(val -> passStyleChoice.getItems().add(rb.getString(val.key())));
        passStyleChoice.setValue(rb.getString(team.predefPassingStyle().orElse(PassingStyle.NORMAL).key()));
        Stream.of(Philosophy.values())
                .forEach(val -> philosophyChoice.getItems().add(rb.getString(val.key())));
        philosophyChoice.setValue(rb.getString(team.predefPhilosophy().orElse(Philosophy.NORMAL).key()));
    }

    public void showMatch() {
        LOG.log(Level.FINE, "showMatch");
        navigator.load(new MatchView());
    }

    public void skipMatch() {
        LOG.log(Level.FINE, "skipMatch");
        //TODO simulate match
        navigator.load(new PostmatchView());
    }
}

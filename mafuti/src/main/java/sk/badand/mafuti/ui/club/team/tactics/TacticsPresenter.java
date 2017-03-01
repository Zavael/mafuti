package sk.badand.mafuti.ui.club.team.tactics;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import sk.badand.mafuti.model.Team;
import sk.badand.mafuti.model.tactic.*;
import sk.badand.mafuti.services.inject.UsersClubHolder;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 * Created by abadinka.
 */
public class TacticsPresenter implements Initializable {

    private static final Logger LOG = Logger.getLogger(TacticsPresenter.class.getName());

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

    @Inject
    UsersClubHolder usersClubHolder;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Stream.of(Marking.values())
                .forEach(val -> markingChoice.getItems().add(rb.getString(val.key)));
        Stream.of(Tackling.values())
                .forEach(val -> tacklingChoice.getItems().add(rb.getString(val.key)));
        Stream.of(CounterAttacks.values())
                .forEach(val -> counterAttChoice.getItems().add(rb.getString(val.key)));
        Stream.of(PassingFocus.values())
                .forEach(val -> passFocusChoice.getItems().add(rb.getString(val.key)));
        Stream.of(PassingStyle.values())
                .forEach(val -> passStyleChoice.getItems().add(rb.getString(val.key)));
        Stream.of(Philosophy.values())
                .forEach(val -> philosophyChoice.getItems().add(rb.getString(val.key)));

        /*Team team = usersClubHolder.getTeams().parallelStream()
                .filter(t -> t.getPriority() == 0)
                .findFirst()
                .get();
        loadPredefTactic(team, rb);*/
    }

    private void loadPredefTactic(Team team, ResourceBundle rb) {
        markingChoice.setValue(rb.getString(team.predefMarking().orElse(Marking.predefined()).key));
        tacklingChoice.setValue(rb.getString(team.predefTackling().orElse(Tackling.predefined()).key));
        counterAttChoice.setValue(rb.getString(team.predefCounterAttacks().orElse(CounterAttacks.predefined()).key));
        passFocusChoice.setValue(rb.getString(team.predefPassingFocus().orElse(PassingFocus.predefined()).key));
        passStyleChoice.setValue(rb.getString(team.predefPassingStyle().orElse(PassingStyle.predefined()).key));
        philosophyChoice.setValue(rb.getString(team.predefPhilosophy().orElse(Philosophy.predefined()).key));
    }
}

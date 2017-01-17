package sk.badand.mafuti.ui.club.team.parts;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import sk.badand.mafuti.model.ManagerClub;
import sk.badand.mafuti.model.Team;
import sk.badand.mafuti.model.tactic.*;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Stream;

/**
 * Created by abadinka.
 */
public class TacticsPresenter implements Initializable {


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
    ManagerClub managerClub;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        /*Team team = managerClub.getTeams().parallelStream()
                .filter(t -> t.getPriority() == 0)
                .findFirst()
                .get();*/

        Stream.of(Marking.values())
                .forEach(val -> markingChoice.getItems().add(rb.getString(val.key())));
        Stream.of(Tackling.values())
                .forEach(val -> tacklingChoice.getItems().add(rb.getString(val.key())));
        Stream.of(CounterAttacks.values())
                .forEach(val -> counterAttChoice.getItems().add(rb.getString(val.key())));
        Stream.of(PassingFocus.values())
                .forEach(val -> passFocusChoice.getItems().add(rb.getString(val.key())));
        Stream.of(PassingStyle.values())
                .forEach(val -> passStyleChoice.getItems().add(rb.getString(val.key())));
        Stream.of(Philosophy.values())
                .forEach(val -> philosophyChoice.getItems().add(rb.getString(val.key())));

        //loadPredefTactic(team, rb);
    }

    private void loadPredefTactic(Team team, ResourceBundle rb) {
        markingChoice.setValue(rb.getString(team.predefMarking().orElse(Marking.MAN).key()));
        tacklingChoice.setValue(rb.getString(team.predefTackling().orElse(Tackling.NORMAL).key()));
        counterAttChoice.setValue(rb.getString(team.predefCounterAttacks().orElse(CounterAttacks.SOMETIMES).key()));
        passFocusChoice.setValue(rb.getString(team.predefPassingFocus().orElse(PassingFocus.MIXED).key()));
        passStyleChoice.setValue(rb.getString(team.predefPassingStyle().orElse(PassingStyle.NORMAL).key()));
        philosophyChoice.setValue(rb.getString(team.predefPhilosophy().orElse(Philosophy.NORMAL).key()));
    }
}

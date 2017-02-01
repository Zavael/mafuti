package sk.badand.mafuti.ui.club.team.formation;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import sk.badand.mafuti.services.TacticService;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by abadinka.
 */
public class FormationPresenter implements Initializable{

    public Label formationTitle;
    @Inject
    TacticService tacticService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        formationTitle.setText("4-4-2");
    }
}

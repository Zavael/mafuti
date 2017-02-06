package sk.badand.mafuti.ui.club.team.formation;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sk.badand.mafuti.model.tactic.Formation;
import sk.badand.mafuti.services.TacticService;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by abadinka.
 */
public class FormationPresenter implements Initializable{

    public Label formationTitle;
    public ImageView image;
    public TextArea description;

    private SimpleObjectProperty<Formation> selectedFormation = new SimpleObjectProperty<>();
    @Inject
    TacticService tacticService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectedFormation.addListener((observableValue, formation, newFormation) -> {
            formationTitle.setText(newFormation.getKey());
            image.setImage(new Image(newFormation.getImagePath()));
            description.setText(newFormation.affectOnTactic);
        });

        selectedFormation.setValue(tacticService.getFormations().get(0));
    }

    public void nextFormation(ActionEvent actionEvent) {
        int formationIndex = tacticService.getFormations().indexOf(selectedFormation.getValue());
        formationIndex++;
        if (formationIndex == tacticService.getFormations().size()) {
            formationIndex = 0;
        }

        selectedFormation.setValue(tacticService.getFormations().get(formationIndex));
    }

    public void previousFormation(ActionEvent actionEvent) {
        int formationIndex = tacticService.getFormations().indexOf(selectedFormation.getValue());
        if (formationIndex == 0) {
            formationIndex = tacticService.getFormations().size();
        }
        formationIndex--;

        selectedFormation.setValue(tacticService.getFormations().get(formationIndex));
    }
}

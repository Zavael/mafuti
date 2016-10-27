/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.training.programs;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import sk.badand.mafuti.model.training.TrainingRegime;
import sk.badand.mafuti.services.TrainingService;

import javax.inject.Inject;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class ProgramsPresenter implements Initializable {

    public ListView<TrainingRegime> programsListView;
    public HBox affectedSkills;
    public Label regimeName;
    public TextFlow regimeDescription;

    @Inject
    TrainingService trainingService;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        programsListView.getItems().addAll(trainingService.getPredefinedRegimes());

        programsListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            affectedSkills.getChildren().clear();
            newValue.getAffectedSkills().forEach(playerSkill -> {
                affectedSkills.getChildren().add(new Label(playerSkill.getName()));
            });
            regimeName.setText(newValue.getName());
            regimeDescription.getChildren().setAll(new Text(newValue.getDescription()));
        });
    }    
    
}

/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.world.competitions;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import sk.badand.mafuti.model.common.Nation;
import sk.badand.mafuti.services.LeagueService;
import sk.badand.mafuti.ui.factories.ComboBoxNationFactory;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class CompetitionsPresenter implements Initializable {

    @FXML
    public ComboBox<Nation> nationsCombo;

    @Inject
    private LeagueService leagueService;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nationsCombo.setCellFactory(new ComboBoxNationFactory());

        leagueService.getLeagueSystems().stream()
                .forEach(leagueSystem -> nationsCombo.getItems().add(leagueSystem.getNation()));
    }
    
}

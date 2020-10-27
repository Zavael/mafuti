/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.world.competitions;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import sk.badand.mafuti.model.Club;
import sk.badand.mafuti.model.club.Team;
import sk.badand.mafuti.model.common.Nation;
import sk.badand.mafuti.model.league.Cup;
import sk.badand.mafuti.model.league.League;
import sk.badand.mafuti.services.LeagueService;
import sk.badand.mafuti.ui.factories.ComboBoxNationFactory;
import sk.badand.mafuti.ui.factories.ListViewClubFactory;
import sk.badand.mafuti.ui.factories.ListViewLeagueFactory;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class CompetitionsPresenter implements Initializable {

    @FXML
    public ComboBox<Nation> nationsCombo;
    public ListView<League> leaguesListView;
    public ListView<Cup> cupsListView;
    public Label leagueNameLbl;
    public ListView<Club> clubsListView;

    @Inject
    private LeagueService leagueService;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nationsCombo.setButtonCell(new ComboBoxNationFactory().call(null));
        nationsCombo.setPromptText(rb.getString("cb.nations.prompt"));
        nationsCombo.setCellFactory(new ComboBoxNationFactory());
        nationsCombo.getSelectionModel().selectedItemProperty().addListener((observableValue, oldNation, newNation) -> {
            if (newNation != null) {
                leaguesListView.getItems().clear();
                leaguesListView.getItems().addAll(leagueService.getLeagues(newNation));
            }
        });

        leaguesListView.setCellFactory(new ListViewLeagueFactory());
        clubsListView.setCellFactory(new ListViewClubFactory());
        leaguesListView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldLeague, newLeague) -> {
            if (newLeague != null) {
                leagueNameLbl.setText(newLeague.getName());
                clubsListView.getItems().clear();
                clubsListView.getItems().addAll(
                        newLeague.getTeams().stream()
                .map(Team::getClub)
                .collect(Collectors.toList()));
            }
        });

        leagueService.getLeagueSystems().stream()
                .forEach(leagueSystem -> nationsCombo.getItems().add(leagueSystem.getNation()));
    }
    
}

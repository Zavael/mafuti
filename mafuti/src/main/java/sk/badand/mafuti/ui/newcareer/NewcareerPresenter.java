package sk.badand.mafuti.ui.newcareer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import sk.badand.mafuti.model.club.Team;
import sk.badand.mafuti.model.common.Nation;
import sk.badand.mafuti.model.league.League;
import sk.badand.mafuti.services.LeagueService;
import sk.badand.mafuti.services.NationService;
import sk.badand.mafuti.ui.dashboard.DashboardView;
import sk.badand.mafuti.ui.factories.ComboBoxLeagueFactory;
import sk.badand.mafuti.ui.factories.ComboBoxNationFactory;
import sk.badand.mafuti.ui.navigation.AbstractNavigator;

import javax.inject.Inject;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class NewcareerPresenter extends AbstractNavigator {
    @FXML
    public ComboBox<Nation> nationalityCombo;
    @FXML
    public ComboBox<Nation> nationsCombo;
    @FXML
    public ComboBox<League> leaguesCombo;
    @FXML
    public FlowPane clubsFlowPane;
    @Inject
    private LeagueService leagueService;
    @Inject
    private NationService nationService;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nationalityCombo.setButtonCell(new ComboBoxNationFactory().call(null));
        nationalityCombo.setPromptText(rb.getString("cb.nations.prompt"));
        nationalityCombo.setCellFactory(new ComboBoxNationFactory());
        nationsCombo.setButtonCell(new ComboBoxNationFactory().call(null));
        nationsCombo.setPromptText(rb.getString("cb.nations.prompt"));
        nationsCombo.setCellFactory(new ComboBoxNationFactory());
        leaguesCombo.setButtonCell(new ComboBoxLeagueFactory().call(null));
        leaguesCombo.setPromptText(rb.getString("cb.nations.prompt"));
        leaguesCombo.setCellFactory(new ComboBoxLeagueFactory());

        nationService.getNations()
                .forEach(nation -> {
                    nationalityCombo.getItems().add(nation);
                    nationsCombo.getItems().add(nation);
                });

        nationsCombo.getSelectionModel().selectedItemProperty().addListener((observableValue, oldNation, newNation) -> {
            if (newNation != null) {
                clubsFlowPane.getChildren().clear();
                leaguesCombo.getItems().clear();
                List<League> leagues = leagueService.getLeagues(newNation);
                leaguesCombo.getItems().addAll(leagues);
            }
        });


        leaguesCombo.getSelectionModel().selectedItemProperty().addListener((observableValue, oldLeague, newLeague) -> {
            if (newLeague != null) {
                clubsFlowPane.getChildren().clear();
                newLeague.getTeams().stream()
                        .map(Team::getClub)
                        .forEach(club -> {
                            VBox clubbox = new VBox();
                            clubbox.setAlignment(Pos.CENTER);
                            clubbox.getChildren().addAll(
                                    new ImageView("/images/mock_profile_100x100.png"),//TODO replace with correct img
                                    new Label(club.getName())
                            );
                            clubsFlowPane.getChildren().add(clubbox);
                        });
            }
        });
    }

    public void startGame(ActionEvent actionEvent) {
        navigator.load(new DashboardView());
    }
}

package sk.badand.mafuti.ui.editor.main;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import lombok.extern.java.Log;
import sk.badand.mafuti.model.Club;
import sk.badand.mafuti.model.club.Team;
import sk.badand.mafuti.model.common.Nation;
import sk.badand.mafuti.model.league.Cup;
import sk.badand.mafuti.model.league.League;
import sk.badand.mafuti.model.league.LeagueLevel;
import sk.badand.mafuti.model.league.LeagueSystem;
import sk.badand.mafuti.services.LeagueService;
import sk.badand.mafuti.ui.editor.NewLeagueLevelPopup;
import sk.badand.mafuti.ui.editor.NewLeaguePopup;
import sk.badand.mafuti.ui.editor.club.ClubPresenter;
import sk.badand.mafuti.ui.editor.club.ClubView;
import sk.badand.mafuti.ui.factories.ComboBoxNationFactory;
import sk.badand.mafuti.ui.factories.ListViewClubFactory;
import sk.badand.mafuti.ui.factories.ListViewLeagueFactory;
import sk.badand.mafuti.ui.navigation.AbstractNavigator;

import javax.inject.Inject;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

@Log
public class MainPresenter extends AbstractNavigator {
//    private static final Logger logger = Logger.getLogger(MainPresenter.class.getName());

    public ComboBox<Nation> nationsCombo;
    public ListView<League> leaguesListView;
    public ListView<Cup> cupsListView;
    public ListView<Club> clubsListView;
    public Pane clubPane;
    public ComboBox<Integer> leagueLevelsCombo;
    public Button btnAddLeagueLevel;
    public Button btnAddClub;
    public Button btnAddLeague;
    public Button btnAddCup;

    @Inject
    LeagueService leagueService;
    private Nation selectedNation;
    private League selectedLeague;
    private Club selectedClub;
    private Integer selectedLevel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnAddLeagueLevel.disableProperty().bind(nationsCombo.valueProperty().isNull());
        btnAddCup.disableProperty().bind(nationsCombo.valueProperty().isNull());
        btnAddLeague.disableProperty().bind(leagueLevelsCombo.valueProperty().isNull());
        btnAddClub.disableProperty().bind(leaguesListView.getSelectionModel().selectedItemProperty().isNull());
        nationsCombo.setButtonCell(new ComboBoxNationFactory().call(null));
        nationsCombo.setCellFactory(new ComboBoxNationFactory());
        nationsCombo.getSelectionModel().selectedItemProperty().addListener((observableValue, oldNation, newNation) -> {
            if (newNation != null) {
                this.selectedNation = newNation;
                leagueLevelsCombo.getItems().clear();
                leagueService.getLeagueSystem(selectedNation).ifPresent(leagueSystem ->
                        leagueSystem.getLeagueLevels().keySet().forEach(integer ->
                                leagueLevelsCombo.getItems().add(integer)));
            }
        });
        leagueLevelsCombo.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                this.selectedLevel = newValue;
                leaguesListView.getItems().clear();
                leaguesListView.getItems().addAll(
                        leagueService.getLeagueSystem(selectedNation)
                                .map(LeagueSystem::getLeagueLevels)
                                .flatMap(levelHashMap ->
                                        levelHashMap.entrySet().stream()
                                                .filter(integerLeagueLevelEntry -> integerLeagueLevelEntry.getKey() == selectedLevel)
                                                .findFirst()
                                                .map(Map.Entry::getValue)
                                                .map(LeagueLevel::getLeagues)
                                )
                                .orElse(Collections.emptyList())
                );
            }
        });
        leaguesListView.setCellFactory(new ListViewLeagueFactory());
        leaguesListView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldLeague, newLeague) -> {
            if (newLeague != null) {
                this.selectedLeague = newLeague;
                clubsListView.getItems().clear();
                clubsListView.getItems().addAll(
                        newLeague.getTeams().stream()
                                .map(Team::getClub)
                                .collect(Collectors.toList()));
            }
        });
        clubsListView.setCellFactory(new ListViewClubFactory());
        clubsListView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldClub, newClub) -> {
            if (newClub != null) {
                this.selectedClub = newClub;
                initClubPane();
            }
        });

        nationsCombo.getItems().addAll(getNations());
    }

    public List<Nation> getNations() {
        List<Nation> nations = new ArrayList<>();
        for (String country : Locale.getISOCountries()) {
            Locale locale = new Locale("", country);
            Nation nation = new Nation(locale.getISO3Country(), locale.getDisplayCountry());
            nations.add(nation);
        }
        return nations;
    }

    public void addLeague(ActionEvent actionEvent) {
        leagueService.getLeagueSystem(selectedNation).ifPresent(leagueSystem -> {
            Optional<League> league1 = new NewLeaguePopup().showAndWait();
            league1.ifPresent(league -> {
                leagueSystem.getLeagueLevels()
                        .get(selectedLevel)
                        .getLeagues()
                        .add(league);
            });
        });
        reloadData(null);
    }

    public void addCup(ActionEvent actionEvent) {

    }

    public void addClub(ActionEvent actionEvent) {
        this.selectedClub = null;
        initClubPane();
    }

    private void initClubPane() {
        log.info("init");
        this.clubPane.getChildren().clear();
        ClubView clubView = new ClubView();
        clubView.getPresenter(presenter -> {
            ClubPresenter clubPresenter = (ClubPresenter) presenter;
//            clubPresenter.setClub(selectedClub);
        });
        this.clubPane.getChildren().add(clubView.getView());
        Button button = new Button("Save");
        this.clubPane.getChildren().add(button);
    }

    public void reloadData(ActionEvent actionEvent) {
        clubsListView.getItems().clear();
        leaguesListView.getItems().clear();
        cupsListView.getItems().clear();
        this.clubPane.getChildren().clear();
        nationsCombo.getSelectionModel().select(-1);
        nationsCombo.getSelectionModel().select(selectedNation);
        leagueLevelsCombo.getSelectionModel().select(selectedLevel);
        leaguesListView.getSelectionModel().select(selectedLeague);
        clubsListView.getSelectionModel().select(selectedClub);
    }

    public void addLeagueLevel(ActionEvent actionEvent) {
        LeagueSystem leagueSystem = leagueService.initOrGetLeagueSystem(selectedNation);

        new NewLeagueLevelPopup(selectedNation.country)
                .showAndWait()
                .ifPresent(level -> {
                    int leagueLevel = Integer.parseInt(level);
                    leagueSystem.getLeagueLevels().put(leagueLevel, new LeagueLevel(leagueSystem.getId() + leagueLevel, (byte) 2, new ArrayList<>()));
                });

        reloadData(null);
    }
}

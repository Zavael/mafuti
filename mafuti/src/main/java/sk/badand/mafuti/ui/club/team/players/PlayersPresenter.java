package sk.badand.mafuti.ui.club.team.players;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sk.badand.mafuti.model.match.Player;
import sk.badand.mafuti.services.inject.UsersClubHolder;
import sk.badand.mafuti.ui.factories.TableColumnAgeFactory;
import sk.badand.mafuti.ui.factories.TableColumnFitnessFactory;
import sk.badand.mafuti.ui.factories.TableColumnMoraleFactory;
import sk.badand.mafuti.ui.factories.TableColumnNationFactory;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * Created by abadinka.
 */
public class PlayersPresenter implements Initializable {
    private static final Logger LOG = Logger.getLogger(PlayersPresenter.class.getName());
    @FXML
    public TableColumn reservesNationalityColumn;
    @FXML
    public TableColumn squadNationalityColumn;
    @FXML
    public TableColumn ageColumn;
    @FXML
    public TableColumn moraleColumn;
    @FXML
    public TableColumn reservesAgeColumn;
    @FXML
    public TableColumn reservesFitnessColumn;
    @FXML
    public TableColumn reservesMoraleColumn;
    @FXML
    public TableColumn fitnessColumn;

    public TableView<Player> squadList;
    public TableView<Player> reservesList;
    @Inject
    UsersClubHolder usersClubHolder;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        reservesNationalityColumn.setCellFactory(new TableColumnNationFactory(resourceBundle));
        squadNationalityColumn.setCellFactory(new TableColumnNationFactory(resourceBundle));
        fitnessColumn.setCellFactory(new TableColumnFitnessFactory());
        reservesFitnessColumn.setCellFactory(new TableColumnFitnessFactory());
        ageColumn.setCellFactory(new TableColumnAgeFactory());
        reservesAgeColumn.setCellFactory(new TableColumnAgeFactory());
        moraleColumn.setCellFactory(new TableColumnMoraleFactory(resourceBundle));
        reservesMoraleColumn.setCellFactory(new TableColumnMoraleFactory(resourceBundle));
        usersClubHolder.getClub().getTeams().stream().findFirst().get()
                .getPlayers().stream()
                .forEach(player -> {
                    LOG.fine("player " + player);
                    if (!player.isInjured()) {
                        this.squadList.getItems().add(player);
                    } else {
                        this.reservesList.getItems().add(player);
                    }
                });
    }
}

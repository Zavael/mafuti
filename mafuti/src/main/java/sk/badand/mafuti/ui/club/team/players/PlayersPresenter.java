package sk.badand.mafuti.ui.club.team.players;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sk.badand.mafuti.data.Data;
import sk.badand.mafuti.match.engine.MatchEngineProvider;
import sk.badand.mafuti.model.match.Player;
import sk.badand.mafuti.services.UserService;
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

    @Inject
    UserService userService;
    public TableView<Player> squadList;
    public TableView<Player> reservesList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        reservesNationalityColumn.setCellFactory(new TableColumnNationFactory(resourceBundle));
        squadNationalityColumn.setCellFactory(new TableColumnNationFactory(resourceBundle));
        userService.getClub().getTeams().stream().findFirst().get()
                .getPlayers().stream()
                .forEach(player -> {
                    LOG.fine("player " + player);
                    if (!player.isInjured()) {
                        this.squadList.getItems().add(player);
                    } else {
                        this.reservesList.getItems().add(player);
                    }
                });
        this.squadList.getItems().addAll(

        );
    }
}

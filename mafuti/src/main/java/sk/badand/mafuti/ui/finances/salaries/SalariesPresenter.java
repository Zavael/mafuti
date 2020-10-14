/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.finances.salaries;

import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sk.badand.mafuti.model.Staff;
import sk.badand.mafuti.model.match.Player;
import sk.badand.mafuti.services.inject.UsersClubHolder;
import sk.badand.mafuti.ui.factories.TableColumnNationFactory;
import sk.badand.mafuti.ui.factories.TableColumnPersonTypeFactory;
import sk.badand.mafuti.ui.factories.TableColumnReputationFactory;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class SalariesPresenter implements Initializable {

    public TableView<Player> playersTable;
    public TableView<Staff> staffTable;
    public TableColumn playerNationColumn;
    public TableColumn playerReputationColumn;
    public TableColumn staffTypeColumn;
    public TableColumn staffNationColumn;
    public TableColumn staffReputationColumn;
    @Inject
    UsersClubHolder usersClubHolder;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        playerNationColumn.setCellFactory(new TableColumnNationFactory(rb));
        staffNationColumn.setCellFactory(new TableColumnNationFactory(rb));
        playerReputationColumn.setCellFactory(new TableColumnReputationFactory(rb));
        staffReputationColumn.setCellFactory(new TableColumnReputationFactory(rb));
        staffTypeColumn.setCellFactory(new TableColumnPersonTypeFactory(rb));

        staffTable.getItems().addAll(usersClubHolder.getClub().getStaff());
        usersClubHolder.getClub().getTeams()
                .forEach(team -> playersTable.getItems().addAll(team.getPlayers()));
    }

}

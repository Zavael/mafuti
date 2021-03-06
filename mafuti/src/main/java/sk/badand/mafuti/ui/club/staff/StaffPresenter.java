/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.club.staff;

import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sk.badand.mafuti.model.Staff;
import sk.badand.mafuti.services.inject.UsersClubHolder;
import sk.badand.mafuti.ui.factories.TableColumnNationFactory;
import sk.badand.mafuti.ui.factories.TableColumnReputationFactory;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class StaffPresenter implements Initializable {

    public TableView<Staff> coachesTable;
    public TableView<Staff> physiosTable;
    public TableView<Staff> scoutsTable;
    public TableColumn coachReputationColumn;
    public TableColumn coachNationColumn;
    public TableColumn physioNationColumn;
    public TableColumn physioReputationColumn;
    public TableColumn scoutNationColumn;
    public TableColumn scoutReputationColumn;

    @Inject
    UsersClubHolder usersClubHolder;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usersClubHolder.getClub().getStaff()
                .forEach(staff -> {
                    switch (staff.getPersonType()) {
                        case COACH: coachesTable.getItems().add(staff); break;
                        case PHYSIO: physiosTable.getItems().add(staff); break;
                        case SCOUT: scoutsTable.getItems().add(staff); break;
                    }
                });

        coachReputationColumn.setCellFactory(new TableColumnReputationFactory(rb));
        coachNationColumn.setCellFactory(new TableColumnNationFactory(rb));
        physioReputationColumn.setCellFactory(new TableColumnReputationFactory(rb));
        physioNationColumn.setCellFactory(new TableColumnNationFactory(rb));
        scoutReputationColumn.setCellFactory(new TableColumnReputationFactory(rb));
        scoutNationColumn.setCellFactory(new TableColumnNationFactory(rb));
    }
}

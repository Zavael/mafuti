/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.dashboard;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableView;
import sk.badand.mafuti.services.CalendarService;
import sk.badand.mafuti.services.ClubService;
import sk.badand.mafuti.services.inject.UsersClubHolder;
import sk.badand.mafuti.ui.navigation.AbstractNavigator;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class DashboardPresenter extends AbstractNavigator {

    private static final Logger LOG = Logger.getLogger(DashboardPresenter.class.getName());

    @FXML
    TableView leagueTableList;
    @FXML
    PieChart chart;
    @Inject
    CalendarService calendarService;
    @Inject
    ClubService clubService;
    @Inject
    UsersClubHolder usersClubHolder;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        navigator.loadMenu();
        chart.getData().addAll(
                FXCollections.observableArrayList(
                        new PieChart.Data("Wins", 25),
                        new PieChart.Data("Draws", 13),
                        new PieChart.Data("Loses", 10))
        );
    }
}

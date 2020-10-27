/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.dashboard;

import com.airhacks.afterburner.injection.Injector;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableView;
import sk.badand.mafuti.model.Club;
import sk.badand.mafuti.services.CalendarService;
import sk.badand.mafuti.services.ClubService;
import sk.badand.mafuti.services.UserService;
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
    UserService userService;
    Club club;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        club = userService.getClub().get(); //FIXME either handle empty optional or do not use optional
        chart.getData().addAll(
                FXCollections.observableArrayList(
                        new PieChart.Data("Wins", 25),
                        new PieChart.Data("Draws", 13),
                        new PieChart.Data("Loses", 10))
        );
        Injector.setModelOrService(UsersClubHolder.class, new UsersClubHolder(club));
    }
}

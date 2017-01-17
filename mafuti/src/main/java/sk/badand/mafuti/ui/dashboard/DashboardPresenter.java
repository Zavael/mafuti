/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.dashboard;

import com.airhacks.afterburner.injection.Injector;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ButtonType;
import javax.inject.Inject;

import sk.badand.mafuti.model.ManagerClub;
import sk.badand.mafuti.services.CalendarService;
import sk.badand.mafuti.model.match.PlayableMatch;
import sk.badand.mafuti.services.mock.MockClub;
import sk.badand.mafuti.util.QuestionDialog;
import sk.badand.mafuti.ui.club.ClubView;
import sk.badand.mafuti.ui.facilities.FacilitiesView;
import sk.badand.mafuti.ui.finances.FinancesView;
import sk.badand.mafuti.ui.manager.ManagerView;
import sk.badand.mafuti.ui.prematch.PrematchView;
import sk.badand.mafuti.ui.navigation.AbstractNavigator;
import sk.badand.mafuti.ui.timeprogress.TimeprogressView;
import sk.badand.mafuti.ui.training.TrainingView;
import sk.badand.mafuti.ui.world.WorldView;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class DashboardPresenter extends AbstractNavigator {

    private static final Logger LOG = Logger.getLogger(DashboardPresenter.class.getName());

    @FXML
    PieChart chart;
    @Inject
    CalendarService calendarService;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        chart.getData().addAll(
                FXCollections.observableArrayList(
                        new PieChart.Data("Wins", 25),
                        new PieChart.Data("Draws", 13),
                        new PieChart.Data("Loses", 10))
        );
        Injector.setModelOrService(ManagerClub.class, new MockClub());
    }

    public void processTime() {
        LOG.log(Level.FINE, "processTime");
        if (calendarService.isManagerPlaying(calendarService.currentDate())) {
            new QuestionDialog("yes or no").showAndWait()
                    .filter(result -> result == ButtonType.OK)
                    .ifPresent(result -> {
                        PlayableMatch managerMatch = calendarService.managerMatchForDay(calendarService.currentDate());
                        Injector.setModelOrService(PlayableMatch.class, managerMatch);
                        final PrematchView prematchView = new PrematchView();
//                        ((PrematchPresenter) prematchView.getPresenter()).setMatch(managerMatch);
                        navigator.load(prematchView);
                    });
        } else {
            navigator.load(new TimeprogressView());
        }
    }

    public void showTraining() {
        LOG.log(Level.FINE, "showTraining");
        navigator.load(new TrainingView());
    }

    public void showClub() {
        LOG.log(Level.FINE, "showClub");
        navigator.load(new ClubView());
    }

    public void showFacilities() {
        LOG.log(Level.FINE, "showFacilities");
        navigator.load(new FacilitiesView());
    }

    public void showFinances() {
        LOG.log(Level.FINE, "showFinances");
        navigator.load(new FinancesView());
    }

    public void showWorld() {
        LOG.log(Level.FINE, "showWorld");
        navigator.load(new WorldView());
    }

    public void showPersonal() {
        LOG.log(Level.FINE, "showPersonal");
        navigator.load(new ManagerView());
    }
}

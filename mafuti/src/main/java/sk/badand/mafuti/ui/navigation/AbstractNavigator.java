/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.navigation;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javax.inject.Inject;
import sk.badand.mafuti.ui.dashboard.DashboardView;
import sk.badand.mafuti.ui.facilities.FacilitiesView;
import sk.badand.mafuti.ui.finances.FinancesView;
import sk.badand.mafuti.ui.manager.ManagerView;
import sk.badand.mafuti.ui.club.ClubView;
import sk.badand.mafuti.ui.training.TrainingView;
import sk.badand.mafuti.ui.world.WorldView;
import sk.badand.mafuti.util.Navigator;

/**
 *
 * @author abadinka
 */
public abstract class AbstractNavigator implements Initializable {

    private static final Logger LOG = Logger.getLogger(AbstractNavigator.class.getName());

    @Inject
    protected Navigator navigator;

    public void showTraining() {
        LOG.log(Level.INFO, "showTraining");
        navigator.load(new TrainingView());
    }

    public void showClub() {
        LOG.log(Level.INFO, "showClub");
        navigator.load(new ClubView());
    }

    public void showFacilities() {
        LOG.log(Level.INFO, "showFacilities");
        navigator.load(new FacilitiesView());
    }

    public void showFinances() {
        LOG.log(Level.INFO, "showFinances");
        navigator.load(new FinancesView());
    }

    public void showWorld() {
        LOG.log(Level.INFO, "showWorld");
        navigator.load(new WorldView());
    }

    public void showPersonal() {
        LOG.log(Level.INFO, "showPersonal");
        navigator.load(new ManagerView());
    }

    public void showDashboard() {
        navigator.load(new DashboardView());
    }

}

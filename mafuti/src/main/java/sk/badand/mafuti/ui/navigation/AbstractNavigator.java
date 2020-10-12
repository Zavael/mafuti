/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.navigation;

import javafx.fxml.Initializable;
import sk.badand.mafuti.ui.dashboard.DashboardView;
import sk.badand.mafuti.ui.world.search.SearchView;
import sk.badand.mafuti.util.Navigator;

import javax.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abadinka
 */
public abstract class AbstractNavigator implements Initializable {

    protected static final Logger LOG = Logger.getLogger(AbstractNavigator.class.getName());

    @Inject
    protected Navigator navigator;

    public void showDashboard() {
        LOG.log(Level.FINE, "showDashboard");
        navigator.load(new DashboardView());
    }

    public void showSearch() {
        LOG.log(Level.FINE, "showSearch");
        navigator.load(new SearchView());
    }

}

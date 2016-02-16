/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.navigation;

import com.airhacks.afterburner.views.FXMLView;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javax.inject.Inject;
import sk.badand.mafuti.ui.dashboard.DashboardView;
import sk.badand.mafuti.ui.world.WorldPresenter;
import sk.badand.mafuti.ui.world.WorldView;
import sk.badand.mafuti.util.Navigator;

/**
 *
 * @author abadinka
 */
public abstract class AbstractNavigator implements Initializable {

    protected static final Logger LOG = Logger.getLogger(AbstractNavigator.class.getName());

    @Inject
    protected Navigator navigator;
    @FXML
    Pane content;

    public void showDashboard() {
        LOG.log(Level.FINE, "showDashboard");
        navigator.load(new DashboardView());
    }
    
    public void setContent(FXMLView view) {
        content.getChildren().clear();
        content.getChildren().add(view.getView());
    }

    public void showSearch() {
        LOG.log(Level.FINE, "showSearch");
        final WorldView worldView = new WorldView();
        ((WorldPresenter)worldView.getPresenter()).showSearch();
        navigator.load(worldView);
    }

}

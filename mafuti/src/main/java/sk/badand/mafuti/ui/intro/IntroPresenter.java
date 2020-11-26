/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.intro;

import com.airhacks.afterburner.injection.Injector;
import sk.badand.mafuti.services.GameService;
import sk.badand.mafuti.services.inject.UsersClubHolder;
import sk.badand.mafuti.ui.dashboard.DashboardView;
import sk.badand.mafuti.ui.navigation.AbstractNavigator;
import sk.badand.mafuti.ui.newcareer.NewcareerView;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class IntroPresenter extends AbstractNavigator {
    private static final Logger LOG = Logger.getLogger(IntroPresenter.class.getName());

    @Inject
    GameService gameService;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    public void continueGame() {
        LOG.log(Level.FINE, "continueGame");
        Injector.setModelOrService(UsersClubHolder.class,new UsersClubHolder(gameService.loadGame()));
        navigator.load(new DashboardView());
    }

    public void newGame() {
        LOG.log(Level.FINE, "newGame");
        navigator.loadFull(new NewcareerView());
    }

    public void loadGame() {
        LOG.log(Level.FINE, "loadGame");
    }

    public void exitGame() {
        LOG.log(Level.FINE, "exitGame");
    }

    public void verifyAccount() {
        LOG.log(Level.FINE, "verifyAccount");
    }
}

/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.intro;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import sk.badand.mafuti.services.GameService;
import sk.badand.mafuti.ui.dashboard.DashboardView;
import sk.badand.mafuti.ui.navigation.AbstractNavigator;
import sk.badand.mafuti.ui.newcareer.NewcareerView;
import sk.badand.mafuti.util.QuestionDialog;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
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
    @FXML
    public GridPane rootPane;

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
    }

    public void newGame() {
        LOG.log(Level.FINE, "newGame");
        try {
            gameService.newGame();
            navigator.loadFull(new NewcareerView());
        } catch (IOException | ClassNotFoundException e) {
            LOG.log(Level.SEVERE, "Exception starting new game, message:{0}", e.toString());
            new QuestionDialog("Cannot load file: " + e.getLocalizedMessage(), Alert.AlertType.ERROR)
                    .showAndWait();
        }
    }

    public void loadGame() {
        LOG.log(Level.FINE, "loadGame");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open");
        File file = fileChooser.showOpenDialog(rootPane.getScene().getWindow());

        try {
            gameService.loadGame(file);
            navigator.load(new DashboardView());
        } catch (IOException | ClassNotFoundException e) {
            LOG.log(Level.SEVERE, "Exception in loading file from {0}, message:{1}", new Object[]{file.getAbsolutePath(), e});
            new QuestionDialog("Cannot load file: " + e.getLocalizedMessage(), Alert.AlertType.ERROR)
                    .showAndWait();
        }
    }

    public void exitGame() {
        LOG.log(Level.FINE, "exitGame");
    }

    public void verifyAccount() {
        LOG.log(Level.FINE, "verifyAccount");
    }
}

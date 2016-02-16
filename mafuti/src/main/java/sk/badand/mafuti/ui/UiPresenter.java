/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import sk.badand.mafuti.ui.intro.IntroView;
import sk.badand.mafuti.ui.navigation.AbstractNavigator;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class UiPresenter extends AbstractNavigator {

    private static final Logger LOG = Logger.getLogger(UiPresenter.class.getName());

    @FXML
    Pane content;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        navigator.init(content);
        navigator.load(new IntroView());
//        navigator.load(new DashboardMenuView(), new DashboardView());
    }
}

/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import sk.badand.mafuti.ui.intro.IntroView;
import sk.badand.mafuti.ui.menu.MenuView;
import sk.badand.mafuti.ui.navigation.AbstractNavigator;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class UiPresenter extends AbstractNavigator {

    private static final Logger LOG = Logger.getLogger(UiPresenter.class.getName());
    @FXML
    public AnchorPane menu;

    @FXML
    Pane content;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        navigator.initContent(content);
        navigator.initMenu(menu);
        navigator.loadFull(new IntroView());
    }
}

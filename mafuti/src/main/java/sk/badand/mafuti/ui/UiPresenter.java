/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javax.inject.Inject;
import sk.badand.mafuti.ui.dashboard.DashboardMenuView;
import sk.badand.mafuti.ui.dashboard.DashboardView;
import sk.badand.mafuti.util.Navigator;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class UiPresenter implements Initializable {
    
    @Inject
    Navigator navigator;
    
    @FXML
    Pane menu;
    @FXML
    Pane content;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        navigator.init(menu, content);
        navigator.load(new DashboardMenuView(), new DashboardView());
    }    
    
}

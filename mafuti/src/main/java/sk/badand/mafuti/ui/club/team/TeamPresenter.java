/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.club.team;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class TeamPresenter implements Initializable {
    
    @FXML
    Label title;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setTitle(String titleToSet) {
        title.setText(titleToSet);
    }
    
}

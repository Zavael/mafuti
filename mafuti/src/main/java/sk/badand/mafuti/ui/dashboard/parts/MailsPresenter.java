/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.dashboard.parts;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class MailsPresenter implements Initializable {

    @FXML
    ListView<String> mails;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mails.getItems().addAll(
                Stream.of(
                        "New transfer ongoing",
                        "Biggest win in premier league",
                        "New contract offer.",
                        "Match delayed",
                        "Youth report",
                        "Training report",
                        "Bank loan closed")
                .collect(Collectors.toList())
        );
    }

}

/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.dashboard.parts;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;
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
public class MediaNewsPresenter implements Initializable {

    private static final Logger LOG = Logger.getLogger(MediaNewsPresenter.class.getName());

    @FXML
    ListView newsHeaders;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        newsHeaders.getItems().addAll(
                Stream.of(
                        "New hot transfer ongoing",
                        "Biggest win in premier league",
                        "Club punished for transfer cheat",
                        "Foreign expert shared best training methods",
                        "Club went bankrupt",
                        "Team of the week announced",
                        "Last league round evaluation")
                .collect(Collectors.toList())
        );
    }

}

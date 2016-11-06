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
import sk.badand.mafuti.model.common.MediaStory;
import sk.badand.mafuti.services.MailService;
import sk.badand.mafuti.services.MediaNewsService;

import javax.inject.Inject;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class MediaNewsPresenter implements Initializable {

    private static final Logger LOG = Logger.getLogger(MediaNewsPresenter.class.getName());

    @FXML
    ListView<MediaStory> newsHeaders;

    @Inject
    MediaNewsService mediaNewsService;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        newsHeaders.getItems().addAll(
            mediaNewsService.getNews()
        );
    }

}

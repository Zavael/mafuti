/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.dashboard.parts;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import sk.badand.mafuti.model.common.MediaStory;
import sk.badand.mafuti.services.MediaNewsService;
import sk.badand.mafuti.ui.factories.ListViewMediaNewsTitleFactory;

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
    @FXML
    TextArea mediaStoryMessage;

    @Inject
    MediaNewsService mediaNewsService;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        newsHeaders.setCellFactory(new ListViewMediaNewsTitleFactory(rb));
        newsHeaders.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, oldMediaStory, newMediaStory) ->
                        this.mediaStoryMessage.setText(rb.getString(newMediaStory.messageKey)));

        newsHeaders.getItems().addAll(
                mediaNewsService.getNews()
        );
    }

}

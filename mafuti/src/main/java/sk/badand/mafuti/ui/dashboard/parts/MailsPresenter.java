/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.dashboard.parts;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import javafx.stage.StageStyle;
import sk.badand.mafuti.model.common.Mail;
import sk.badand.mafuti.services.MailService;
import sk.badand.mafuti.ui.factories.ListViewMailSubjectFactory;

import javax.inject.Inject;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class MailsPresenter implements Initializable {

    @FXML
    ListView<Mail> mailsTitles;

    @Inject
    MailService mailService;

    private Mail selectedMail;
    private ResourceBundle bundle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bundle = rb;
        mailsTitles.getItems().addAll(
                mailService.getMails()
        );

        mailsTitles.setCellFactory(new ListViewMailSubjectFactory(rb));

        mailsTitles.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> this.selectedMail = newValue);
    }

    @FXML
    public void readMail(){
        selectedMail.setHasBeenRead();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setHeaderText(bundle.getString(selectedMail.subjectKey));
        alert.setContentText(bundle.getString(selectedMail.bodyKey));
        alert.initStyle(StageStyle.UNDECORATED);
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);


        alert.showAndWait();
    }
}

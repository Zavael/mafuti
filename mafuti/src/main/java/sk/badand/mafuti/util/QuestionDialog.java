/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.StageStyle;

import java.util.Optional;

/**
 *
 * @author abadinka
 */
public final class QuestionDialog {

    private final Alert dialogWindow;

    public QuestionDialog(String question, Alert.AlertType type) {
        dialogWindow = new Alert(type);
        dialogWindow.setContentText(question);
        dialogWindow.setHeaderText(null);
        dialogWindow.initStyle(StageStyle.UNDECORATED);
        dialogWindow.getDialogPane().getStylesheets().add(getClass().getResource("/styles/dialogs.css").toExternalForm());
    }

    public Optional<ButtonType> showAndWait() {
        return dialogWindow.showAndWait();
    }

}

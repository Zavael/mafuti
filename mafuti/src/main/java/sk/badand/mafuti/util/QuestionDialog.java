/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.util;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.StageStyle;

/**
 *
 * @author abadinka
 */
public final class QuestionDialog {

    private final Alert dialogWindow;

    public QuestionDialog(String question) {
        dialogWindow = new Alert(Alert.AlertType.CONFIRMATION);
        dialogWindow.setContentText(question);
        dialogWindow.setHeaderText(null);
        dialogWindow.initStyle(StageStyle.UNDECORATED);
        dialogWindow.getDialogPane().getStylesheets().add(getClass().getResource("/styles/dialogs.css").toExternalForm());
    }

    public Optional<ButtonType> showAndWait() {
        return dialogWindow.showAndWait();
    }

}

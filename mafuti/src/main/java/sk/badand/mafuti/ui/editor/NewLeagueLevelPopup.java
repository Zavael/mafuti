package sk.badand.mafuti.ui.editor;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;

public class NewLeagueLevelPopup extends TextInputDialog {
    public NewLeagueLevelPopup(String forNation) {
        setTitle("New league level");
        setHeaderText("Add new league level in nation " + forNation);
        setContentText("League level (number):");

        final Button okButton = (Button) getDialogPane().lookupButton(ButtonType.OK);
        okButton.setDisable(true);
        getEditor().textProperty().addListener((observableValue, s, newString) -> {
            try {
                Integer.valueOf(newString);
                if (newString != null && !newString.isBlank()) {
                    getEditor().setStyle("-fx-border-color:red;");
                } else {
                    getEditor().setStyle("-fx-border-color:black;");
                }
                okButton.setDisable(false);
            } catch (Exception e) {
                okButton.setDisable(true);
            }
        });
    }
}

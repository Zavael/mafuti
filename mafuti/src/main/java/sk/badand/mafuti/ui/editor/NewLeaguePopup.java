package sk.badand.mafuti.ui.editor;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import lombok.extern.java.Log;
import sk.badand.mafuti.model.league.League;

@Log
public class NewLeaguePopup extends Dialog<League> {
    TextField leagueNameTF = new TextField();

    public NewLeaguePopup() {
        setTitle("New league");
        this.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        this.getDialogPane().setContent(layout());
        final Button okButton = (Button) getDialogPane().lookupButton(ButtonType.OK);
        okButton.disableProperty().bind(leagueNameTF.textProperty().isEmpty());
        setResultConverter(buttonType -> {
            if (buttonType == ButtonType.OK) {
                return new League(leagueNameTF.getText().hashCode(), leagueNameTF.getText());
            }
            return null;
        });
    }

    private Node layout() {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

//        grid.add(new Label("Select level:"), 0, 0);
//        grid.add(cbLeagueLevels, 1, 0);
//        GridPane.setColumnSpan(cbLeagueLevels, 2);

        grid.add(new Label("League name:"), 0, 2);
        grid.add(leagueNameTF, 1, 2);
        GridPane.setColumnSpan(leagueNameTF, 2);

        return grid;
    }
}

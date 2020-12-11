package sk.badand.mafuti.ui.editor.intro;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import sk.badand.mafuti.model.Game;
import sk.badand.mafuti.services.data.Data;
import sk.badand.mafuti.services.data.DataLoader;
import sk.badand.mafuti.ui.editor.main.MainView;
import sk.badand.mafuti.ui.navigation.AbstractNavigator;
import sk.badand.mafuti.util.QuestionDialog;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class IntroPresenter extends AbstractNavigator {
    public VBox rootPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void createGame(ActionEvent actionEvent) {
        Data.getInstance().setGame(new Game(new ArrayList<>()));
        navigator.loadFull(new MainView());
    }

    public void loadGame(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open");
        File file = fileChooser.showOpenDialog(rootPane.getScene().getWindow());
        try {
            Data.getInstance().setGame(new DataLoader().loadGame(file));
            navigator.loadFull(new MainView());
        } catch (IOException | ClassNotFoundException e) {
            new QuestionDialog("Cannot load file: " + e.getLocalizedMessage(), Alert.AlertType.ERROR)
                    .showAndWait();
        }
    }
}

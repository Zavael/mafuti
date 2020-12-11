package sk.badand.mafuti.ui.editor;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sk.badand.mafuti.ui.editor.intro.IntroView;
import sk.badand.mafuti.ui.navigation.AbstractNavigator;

import java.net.URL;
import java.util.ResourceBundle;

public class EditorPresenter extends AbstractNavigator {

    public AnchorPane content;
    private Stage primaryStage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        navigator.initContent(content);
        navigator.initMenu(new Pane()); //empty region
        navigator.loadFull(new IntroView());
    }
}

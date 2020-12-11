package sk.badand.mafuti;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sk.badand.mafuti.model.Game;
import sk.badand.mafuti.services.data.Data;
import sk.badand.mafuti.ui.editor.EditorView;
import sk.badand.mafuti.util.LoggingProperties;

import java.util.ArrayList;

public class Editor extends Application {

    static {
        LoggingProperties.setUp();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Data.getInstance().setGame(new Game(new ArrayList<>()));
        Scene scene = new Scene(new EditorView().getView(), 1024, 800);
//        primaryStage.initStyle(StageStyle.);
        primaryStage.setTitle("mafuti");
        scene.getStylesheets().add("/styles/mafuti-light-blue.css");
        primaryStage.centerOnScreen();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

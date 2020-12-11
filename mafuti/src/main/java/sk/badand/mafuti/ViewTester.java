package sk.badand.mafuti;

import com.airhacks.afterburner.views.FXMLView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sk.badand.mafuti.ui.editor.club.ClubView;

public class ViewTester extends Application {
    @Override
    public void start(Stage primaryStage) {

        FXMLView uiView = new ClubView();
//        FXMLView uiView = new CompetitionsView();

        Scene scene = new Scene(uiView.getView(), 1024, 768);
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setTitle("mafuti");
        scene.getStylesheets().add("/styles/mafuti-light-blue.css");
//        scene.getStylesheets().add("/styles/mafuti-dark-blue.css");
//        scene.getStylesheets().add("/styles/JMetroLightTheme.css");
//        scene.getStylesheets().add("/styles/JMetroDarkTheme.css");
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

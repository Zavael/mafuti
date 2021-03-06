/*
 * Copyright 2015 Andrej Badinka
 */
package sk.badand.mafuti;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sk.badand.mafuti.ui.UiView;
import sk.badand.mafuti.util.LoggingProperties;

/**
 *
 * @author abadinka
 */
public class Mafuti extends Application {

    private static Stage mainStage; // needed as parent for modal dialogs

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
    public void start(Stage primaryStage) {

        mainStage = primaryStage;
        UiView uiView = new UiView();

        Scene scene = new Scene(uiView.getView(), 1024, 768);
        mainStage.initStyle(StageStyle.UTILITY);
        mainStage.setTitle("mafuti");
        scene.getStylesheets().add("/styles/mafuti-light-blue.css");
//        scene.getStylesheets().add("/styles/mafuti-dark-blue.css");
//        scene.getStylesheets().add("/styles/JMetroLightTheme.css");
//        scene.getStylesheets().add("/styles/JMetroDarkTheme.css");
        mainStage.centerOnScreen();
        mainStage.setResizable(false);
        mainStage.setScene(scene);
        mainStage.show();
        initEventHandlers(uiView.getView(), mainStage);
    }

    private void initEventHandlers(Parent root, final Stage stageRef) {
//        root.setOnMousePressed((MouseEvent me) -> {
//            dragAnchorX = me.getScreenX() - stageRef.getX();
//            dragAnchorY = me.getScreenY() - stageRef.getY();
//        });
//        
//        root.setOnMouseDragged((MouseEvent me) -> {
//            stageRef.setX(me.getScreenX() - dragAnchorX);
//            stageRef.setY(me.getScreenY() - dragAnchorY);
//        });
//        stageRef.setOnCloseRequest((WindowEvent ev) -> new QuestionDialog("Close?")
//                .showAndWait()
//                .filter(result -> result != ButtonType.OK)
//                .ifPresent(result -> ev.consume()));

    }

    public static void setScene(Scene scene) {
        mainStage.setScene(scene);
    }

}

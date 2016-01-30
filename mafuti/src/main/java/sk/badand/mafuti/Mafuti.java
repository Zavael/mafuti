/*
 * Copyright 2015 Andrej Badinka
 */
package sk.badand.mafuti;

import java.util.Optional;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
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
    public void start(Stage primaryStage) throws Exception {
        
        mainStage = primaryStage;
        UiView uiView = new UiView();
        
        Scene scene = new Scene(uiView.getView(), 1024, 768);
        primaryStage.initStyle(StageStyle.UNIFIED);
        primaryStage.setTitle("mafuti");
        scene.getStylesheets().add("/styles/LightTheme-blue.css");
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
        initEventHandlers(uiView.getView(), primaryStage);
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
        stageRef.setOnCloseRequest((WindowEvent ev) -> {
            Alert closingConfirm = new Alert(Alert.AlertType.CONFIRMATION);
            closingConfirm.setTitle("Alert");
            closingConfirm.setContentText("Close?");
            Optional<ButtonType> result = closingConfirm.showAndWait();
            if (result.get() != ButtonType.OK) {
                ev.consume();
            }
        });

    }

}

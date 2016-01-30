/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.util;

import com.airhacks.afterburner.views.FXMLView;
import javafx.scene.layout.Pane;

/**
 *
 * @author abadinka
 */
public class Navigator {        
    private static Pane contentPane;
    private static Pane menuPane;
    
    public void init(Pane menu, Pane content) {
        contentPane = content;
        menuPane = menu;
    }    
    
    public void load(FXMLView menuView, FXMLView contentView) {
        menuPane.getChildren().clear();
        menuPane.getChildren().add(menuView.getView());
        contentPane.getChildren().clear();
        contentPane.getChildren().add(contentView.getView());
    }  
}

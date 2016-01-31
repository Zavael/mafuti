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
    
    public void init(Pane content) {
        contentPane = content;
    }    
    
    public void load(FXMLView contentView) {
        contentPane.getChildren().clear();
        contentPane.getChildren().add(contentView.getView());
    }  
}

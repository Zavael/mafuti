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
    private static Pane menu;

    public void initContent(Pane content) {
        contentPane = content;
    }    

    public void initMenu(Pane content) {
        menu = content;
    }

    public void load(FXMLView contentView) {
        visibleMenu(true);
        contentPane.getChildren().clear();
        contentPane.getChildren().add(contentView.getView());
    }

    public void loadFull(FXMLView contentView) {
        visibleMenu(false);
        contentPane.getChildren().clear();
        contentPane.getChildren().add(contentView.getView());
    }

    private void visibleMenu(boolean b) {
        menu.setManaged(b);
        menu.setVisible(b);
    }
}

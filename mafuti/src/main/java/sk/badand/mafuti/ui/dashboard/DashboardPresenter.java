/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.dashboard;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import sk.badand.mafuti.ui.prematch.PrematchView;
import sk.badand.mafuti.ui.navigation.AbstractNavigator;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class DashboardPresenter extends AbstractNavigator {

    private static final Logger LOG = Logger.getLogger(DashboardPresenter.class.getName());

    @FXML
    PieChart chart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        chart.getData().addAll(
                FXCollections.observableArrayList(
                        new PieChart.Data("Wins", 25),
                        new PieChart.Data("Draws", 13),
                        new PieChart.Data("Loses", 10))
        );
    }

    public void processTime() {
        LOG.log(Level.INFO, "processTime");
        navigator.load(new PrematchView());
    }

}

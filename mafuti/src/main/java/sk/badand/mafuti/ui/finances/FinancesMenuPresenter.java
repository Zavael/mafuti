/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.finances;

import sk.badand.mafuti.ui.navigation.AbstractNavigator;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class FinancesMenuPresenter extends AbstractNavigator {

    private static final Logger LOG = Logger.getLogger(FinancesMenuPresenter.class.getName());

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void showSummary() {
        LOG.log(Level.INFO, "showSummary");
    }

    public void showExpenses() {
        LOG.log(Level.INFO, "showExpenses");
    }

    public void showIncomes() {
        LOG.log(Level.INFO, "showIncomes");
    }

    public void showSalaries() {
        LOG.log(Level.INFO, "showSalaries");
    }

    public void showLoans() {
        LOG.log(Level.INFO, "showLoans");
    }

}

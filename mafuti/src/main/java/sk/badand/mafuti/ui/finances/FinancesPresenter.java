/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.finances;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import sk.badand.mafuti.ui.finances.expenses.ExpensesView;
import sk.badand.mafuti.ui.finances.incomes.IncomesView;
import sk.badand.mafuti.ui.finances.loans.LoansView;
import sk.badand.mafuti.ui.finances.salaries.SalariesView;
import sk.badand.mafuti.ui.finances.summary.SummaryView;
import sk.badand.mafuti.ui.navigation.AbstractNavigator;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class FinancesPresenter extends AbstractNavigator {

    private static final Logger LOG = Logger.getLogger(FinancesPresenter.class.getName());

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showSummary();
    }

    public void showSummary() {
        LOG.log(Level.FINE, "showSummary");
        setContent(new SummaryView());
    }

    public void showExpenses() {
        LOG.log(Level.FINE, "showExpenses");
        setContent(new ExpensesView());
    }

    public void showIncomes() {
        LOG.log(Level.FINE, "showIncomes");
        setContent(new IncomesView());
    }

    public void showSalaries() {
        LOG.log(Level.FINE, "showSalaries");
        setContent(new SalariesView());
    }

    public void showLoans() {
        LOG.log(Level.FINE, "showLoans");
        setContent(new LoansView());
    }
}

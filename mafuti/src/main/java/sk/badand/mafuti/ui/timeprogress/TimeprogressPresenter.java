/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.timeprogress;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import sk.badand.mafuti.ui.navigation.AbstractNavigator;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class TimeprogressPresenter extends AbstractNavigator {

    private static final Logger LOG = Logger.getLogger(TimeprogressPresenter.class.getName());
    private static boolean PROCESSING;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LOG.log(Level.FINE, "init");
//        create time progress executor, smthing like this
//        while (PROCESSING) {
//            LOG.log(Level.FINE, "still processing..");
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException ex) {
//                LOG.log(Level.SEVERE, "interrupted {0}", ex);
//            }
//        }
//        showDashboard();
    }
    

    public void abortTimeProgress() {
        LOG.log(Level.FINE, "abort");
        PROCESSING = false;
        showDashboard();
    }

}

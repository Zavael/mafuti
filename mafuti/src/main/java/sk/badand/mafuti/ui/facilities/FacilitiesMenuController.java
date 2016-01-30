/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.facilities;

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
public class FacilitiesMenuController extends AbstractNavigator {

    private static final Logger LOG = Logger.getLogger(FacilitiesMenuController.class.getName());

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void showStadium() {
        LOG.log(Level.INFO, "showStadium");
    }

    public void showOffice() {
        LOG.log(Level.INFO, "showOffice");
    }

    public void showYouthAcademy() {
        LOG.log(Level.INFO, "showYouthAcademy");
    }

    public void showFitnessMedic() {
        LOG.log(Level.INFO, "showFitnessMedic");
    }
}

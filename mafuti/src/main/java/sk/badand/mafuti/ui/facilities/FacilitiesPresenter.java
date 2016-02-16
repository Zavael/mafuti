/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.facilities;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import sk.badand.mafuti.ui.facilities.academy.AcademyView;
import sk.badand.mafuti.ui.facilities.fitness.FitnessView;
import sk.badand.mafuti.ui.facilities.office.OfficeView;
import sk.badand.mafuti.ui.facilities.stadium.StadiumView;
import sk.badand.mafuti.ui.navigation.AbstractNavigator;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class FacilitiesPresenter extends AbstractNavigator {

    private static final Logger LOG = Logger.getLogger(FacilitiesPresenter.class.getName());
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showOffice();
    }

    public void showStadium() {
        LOG.log(Level.FINE, "showStadium");
        setContent(new StadiumView());
    }

    public void showOffice() {
        LOG.log(Level.FINE, "showOffice");
        setContent(new OfficeView());
    }

    public void showYouthAcademy() {
        LOG.log(Level.FINE, "showYouthAcademy");
        setContent(new AcademyView());
    }

    public void showFitnessMedic() {
        LOG.log(Level.FINE, "showFitnessMedic");
        setContent(new FitnessView());
    }
}

/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.ui.training.rehab;

import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import sk.badand.mafuti.model.match.Player;
import sk.badand.mafuti.services.PlayerService;
import sk.badand.mafuti.services.inject.UsersClubHolder;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author abadinka
 */
public class RehabPresenter implements Initializable {

    public TableView<Player> rehabPlayersTable;

    @Inject
    PlayerService playerService;

    @Inject
    UsersClubHolder usersClubHolder;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        playerService.getInjuredPlayers(usersClubHolder.getClub())
                .forEach(injured -> {
                    rehabPlayersTable.getItems().add(injured);
                });
    }    
    
}

package sk.badand.mafuti.services;

import sk.badand.mafuti.data.Data;
import sk.badand.mafuti.model.Club;

public class GameService {

    public Club loadGame() {
        Data.loadInstance();
        return Data.getInstance().getClubs().stream().findAny().get();
    }
}

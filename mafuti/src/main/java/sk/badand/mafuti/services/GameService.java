package sk.badand.mafuti.services;

import com.airhacks.afterburner.injection.Injector;
import sk.badand.mafuti.model.Club;
import sk.badand.mafuti.model.Manager;
import sk.badand.mafuti.model.common.Person;
import sk.badand.mafuti.services.data.Data;
import sk.badand.mafuti.services.data.DataLoader;
import sk.badand.mafuti.services.data.mock.MockDataProvider;
import sk.badand.mafuti.services.inject.UsersClubHolder;

import java.io.File;
import java.io.IOException;

public class GameService {
    private static final String DEFAULT_GAME_PATH = "path to start game";
    DataLoader dataLoader = new DataLoader();

    public void newGame() throws IOException, ClassNotFoundException {
        Data.getInstance().setGame(
                new MockDataProvider().mockGame()
//                dataLoader.loadGame(new File(DEFAULT_GAME_PATH))
        );
    }

    public void loadGame(File file) throws IOException, ClassNotFoundException {
        Data.getInstance().setGame(dataLoader.loadGame(file));
        Injector.setModelOrService(
                UsersClubHolder.class,
                new UsersClubHolder(getUsersClub()));
    }

    public boolean saveGame(File file) throws IOException {
        dataLoader.saveGame(Data.getInstance().getGame(), file);
        return true;
    }

    private Club getUsersClub() {
        return Data.getInstance().getClubs().stream()
                .map(Club::getManager)
                .filter(Manager::isHuman)
                .findFirst()
                .flatMap(Person::getClub)
                .get();
    }
}

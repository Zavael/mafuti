package sk.badand.mafuti.services.data;

import sk.badand.mafuti.model.Game;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataLoader {
    private static final Logger LOG = Logger.getLogger(DataLoader.class.getName());


    public void saveGame(Game game, File file) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(game);
            oos.flush();
            LOG.log(Level.INFO, "Serialized data is saved in {0}", file);
        }
    }

    public Game loadGame(File file) throws IOException, ClassNotFoundException {
        Game result = null;
        try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis)) {
            result = (Game) ois.readObject();
        }
        return result;
    }
}

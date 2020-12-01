package sk.badand.mafuti.services;

import sk.badand.mafuti.model.Club;
import sk.badand.mafuti.model.Manager;
import sk.badand.mafuti.services.data.Data;

import java.util.Optional;

/**
 * Created by abadinka.
 */
public class ManagerService {
    private final Data data = Data.getInstance();

    public Optional<Manager> getManager(Club club) {
        return data.getClubs().stream()
                .filter(club1 -> club1.equals(club))
                .findFirst()
                .map(Club::getManager);
    }
}

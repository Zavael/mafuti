package sk.badand.mafuti.services;

import sk.badand.mafuti.data.Data;
import sk.badand.mafuti.model.common.Nation;

import java.util.*;

/**
 * Created by abadinka.
 */
public class NationService {

    private final Data data = Data.getInstance();
    private final List<Nation> nations = data.getNations();
    private final HashMap<String, Nation> mappedNations = new HashMap<>(nations.size());

    {
        nations.forEach(nation -> {
            mappedNations.put(nation.key, nation);
        });
    }

    public List<Nation> getNations() {
        return nations;
    }

    public Nation getNation(String key) {
        return mappedNations.get(key);
    }
}

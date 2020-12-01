package sk.badand.mafuti.services;

import sk.badand.mafuti.model.common.Nation;
import sk.badand.mafuti.services.data.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by abadinka.
 */
public class NationService {

    private final Data data = Data.getInstance();
    private final List<Nation> nations = new ArrayList<>();
    private final HashMap<String, Nation> mappedNations = new HashMap<>();

    public List<Nation> getNations() {
        return data.getNations();
    }
}

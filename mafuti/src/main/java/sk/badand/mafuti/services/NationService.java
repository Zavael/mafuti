package sk.badand.mafuti.services;

import sk.badand.mafuti.model.common.Nation;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by abadinka.
 */
public class NationService {

    private List<Nation> nations = new ArrayList<>(Locale.getISOCountries().length);
    private HashMap<String, Nation> mappedNations = new HashMap<>(Locale.getISOCountries().length);

    {
        Arrays.stream(Locale.getISOCountries())
                .parallel()
                .map(isoCountry -> new Locale("", isoCountry))
                .forEach(country -> {
                    Nation nation = new Nation(country.getISO3Country(), country.getDisplayCountry());
                    nations.add(nation);
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

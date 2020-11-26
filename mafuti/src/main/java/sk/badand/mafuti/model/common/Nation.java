/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.model.common;

import java.util.Objects;

/**
 *
 * @author abadinka
 */
public class Nation {

    public final String key;
    public final String country; //TODO: move to bundle?

    public Nation(String key, String country) {
        this.country = country;
        this.key = key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nation nation = (Nation) o;
        return key.equals(nation.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    /*
    public static void main(String[] args) {
        System.out.println("Countries");
        for (String country : Locale.getISOCountries()) {
            Locale locale = new Locale("", country);
            System.out.println(
                    "Info: " + locale.getDisplayCountry() + ", " + locale.getISO3Country() + ", " +locale.getISO3Language()
            );
        }
    }
*/
}

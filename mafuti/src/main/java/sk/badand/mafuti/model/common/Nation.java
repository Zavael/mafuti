/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.model.common;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
public class Nation implements Serializable {

    private static final long serialVersionUID = 9093529382492155805L;
    public final String key;
    @EqualsAndHashCode.Exclude
    public final String country; //TODO: move to bundle?

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

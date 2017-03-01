package sk.badand.mafuti.data;

import sk.badand.mafuti.model.Club;

import java.util.List;

/**
 * Created by abadinka.
 */
public class Data {

    private static final DataProvider dataProvider = new MockDataProvider();

    public Data() {

    }

    public static List<Club> getClubs() {
        return dataProvider.getClubs();
    }
}

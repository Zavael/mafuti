package sk.badand.mafuti.data.mock;

import sk.badand.mafuti.model.club.Stadium;
import sk.badand.text.StrGenerator;

/**
 * Created by abadinka.
 */
public class MockStadium extends Stadium {
    public MockStadium() {
        super(new StrGenerator().generateDesignation(8) + " stadium", "Somewhere DC.", 10000);
    }
}

package sk.badand.mafuti.data.mock;

import sk.badand.mafuti.model.match.PlayableStadium;
import sk.badand.text.StrGenerator;

/**
 * Created by abadinka.
 */
public class MockStadium implements PlayableStadium {
    private final String stadiumName = new StrGenerator().generateDesignation(8) + " stadium";

    public MockStadium() {
    }

    @Override
    public String getName() {
        return stadiumName;
    }
}

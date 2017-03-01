package sk.badand.mafuti.services.mock;

import sk.badand.mafuti.model.Budget;
import sk.badand.mafuti.model.Club;
import sk.badand.mafuti.model.Team;
import sk.badand.math.Randomizer;

import java.util.List;

/**
 * Created by abadinka.
 */
public class MockClub extends Club {

    public MockClub(List<Team> teams) {
        super(new String("club_" + new Randomizer().nextRandomInt(10000)),
                new MockManager(),
                teams,
                new Budget() {
                    @Override
                    public int getMoneyAmount() {
                        return 15000;
                    }
                });
    }
}

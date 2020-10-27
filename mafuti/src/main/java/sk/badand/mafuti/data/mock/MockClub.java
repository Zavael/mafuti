package sk.badand.mafuti.data.mock;

import sk.badand.mafuti.model.Budget;
import sk.badand.mafuti.model.Club;
import sk.badand.mafuti.model.Staff;
import sk.badand.mafuti.model.club.Team;
import sk.badand.math.Randomizer;
import sk.badand.text.StrGenerator;

import java.util.List;

/**
 * Created by abadinka.
 */
public class MockClub extends Club {

    public MockClub(List<Team> teams, List<Staff> staff) {
        super("club_" + new Randomizer().nextRandomInt(10000),
                new StrGenerator().generateDesignation(10) + " FC",
                new MockManager(),
                teams,
                staff,
                new Budget() {
                    @Override
                    public int getMoneyAmount() {
                        return 15000;
                    }
                }, new MockStadium());
    }
}

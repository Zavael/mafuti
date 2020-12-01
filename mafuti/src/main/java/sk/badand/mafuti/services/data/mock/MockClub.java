package sk.badand.mafuti.services.data.mock;

import sk.badand.mafuti.model.Budget;
import sk.badand.mafuti.model.Club;
import sk.badand.mafuti.model.Staff;
import sk.badand.mafuti.model.club.Team;
import sk.badand.math.Randomizer;
import sk.badand.text.StrGenerator;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by abadinka.
 */
public class MockClub extends Club {
    private static StrGenerator strgen = new StrGenerator();

    public MockClub(List<Team> teams, List<Staff> staff) {
        super("club_" + new Randomizer().nextRandomInt(10000),
                strgen.generateDesignation(10) + " FC",
                new MockManager(strgen.generateDesignation(6), strgen.generateDesignation(6), LocalDate.now(), new MockNation(), false),
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

package sk.badand.mafuti.services;

import sk.badand.mafuti.model.Club;
import sk.badand.mafuti.model.Staff;
import sk.badand.mafuti.services.mock.MockStaff;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by abadinka.
 */
public class StaffService {

    public List<Staff> getClubStaff(Club club) {
        return Stream.of(
                new MockStaff(),
                new MockStaff(),
                new MockStaff(),
                new MockStaff(),
                new MockStaff(),
                new MockStaff(),
                new MockStaff()
        ).collect(Collectors.toList());
    }
}

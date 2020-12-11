package sk.badand.mafuti.model.club;

import lombok.AllArgsConstructor;

import java.io.Serial;

/**
 * Generates virtual points to unlock new upgrades?
 * Influences income (TV, sponsorship, merchandise), negotiations, loan upper limit, staff upper limit, other facilities upper level limit ...
 */
@AllArgsConstructor
public class Office extends Facility {
    @Serial
    private static final long serialVersionUID = -1039400364606570936L;
}

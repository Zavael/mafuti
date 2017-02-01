package sk.badand.mafuti.model.tactic;

import sk.badand.mafuti.model.match.PlayerPosition;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by abadinka.
 */
public enum FormationType {
    FORM442("formation.442", Stream.of(
            PlayerPosition.WINGBACK, PlayerPosition.DEFENDER, PlayerPosition.DEFENDER, PlayerPosition.WINGBACK,
            PlayerPosition.WINGER, PlayerPosition.MIDFIELDER, PlayerPosition.MIDFIELDER, PlayerPosition.WINGER,
            PlayerPosition.STRIKER, PlayerPosition.STRIKER
    ).collect(Collectors.toList())),
    FORM433("formation.442", Stream.of(
            PlayerPosition.WINGBACK, PlayerPosition.DEFENDER, PlayerPosition.DEFENDER, PlayerPosition.WINGBACK,
            PlayerPosition.WINGER, PlayerPosition.MIDFIELDER, PlayerPosition.MIDFIELDER, PlayerPosition.WINGER,
            PlayerPosition.STRIKER, PlayerPosition.STRIKER
    ).collect(Collectors.toList())),
    FORM451("formation.442", Stream.of(
            PlayerPosition.WINGBACK, PlayerPosition.DEFENDER, PlayerPosition.DEFENDER, PlayerPosition.WINGBACK,
            PlayerPosition.WINGER, PlayerPosition.MIDFIELDER, PlayerPosition.MIDFIELDER, PlayerPosition.WINGER,
            PlayerPosition.STRIKER, PlayerPosition.STRIKER
    ).collect(Collectors.toList())),
    FORM343("formation.442", Stream.of(
            PlayerPosition.WINGBACK, PlayerPosition.DEFENDER, PlayerPosition.DEFENDER, PlayerPosition.WINGBACK,
            PlayerPosition.WINGER, PlayerPosition.MIDFIELDER, PlayerPosition.MIDFIELDER, PlayerPosition.WINGER,
            PlayerPosition.STRIKER, PlayerPosition.STRIKER
    ).collect(Collectors.toList())),
    FORM352("formation.442", Stream.of(
            PlayerPosition.WINGBACK, PlayerPosition.DEFENDER, PlayerPosition.DEFENDER, PlayerPosition.WINGBACK,
            PlayerPosition.WINGER, PlayerPosition.MIDFIELDER, PlayerPosition.MIDFIELDER, PlayerPosition.WINGER,
            PlayerPosition.STRIKER, PlayerPosition.STRIKER
    ).collect(Collectors.toList())),
    FORM541("formation.442", Stream.of(
            PlayerPosition.WINGBACK, PlayerPosition.DEFENDER, PlayerPosition.DEFENDER, PlayerPosition.WINGBACK,
            PlayerPosition.WINGER, PlayerPosition.MIDFIELDER, PlayerPosition.MIDFIELDER, PlayerPosition.WINGER,
            PlayerPosition.STRIKER, PlayerPosition.STRIKER
    ).collect(Collectors.toList())),
    FORM532("formation.442", Stream.of(
            PlayerPosition.WINGBACK, PlayerPosition.DEFENDER, PlayerPosition.DEFENDER, PlayerPosition.WINGBACK,
            PlayerPosition.WINGER, PlayerPosition.MIDFIELDER, PlayerPosition.MIDFIELDER, PlayerPosition.WINGER,
            PlayerPosition.STRIKER, PlayerPosition.STRIKER
    ).collect(Collectors.toList()));

    private static final int FIELD_PLAYERS_COUNT = 10;
    public final String key;
    public final List<PlayerPosition> positions;

    FormationType(String key, List<PlayerPosition> positions) {
        this.key = key;
        this.positions = positions;
        assert this.positions.size() == FIELD_PLAYERS_COUNT;
    }
}

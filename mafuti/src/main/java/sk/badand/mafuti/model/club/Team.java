/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.model.club;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import sk.badand.mafuti.model.Club;
import sk.badand.mafuti.model.league.League;
import sk.badand.mafuti.model.match.Player;
import sk.badand.mafuti.model.tactic.*;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author abadinka
 */
@RequiredArgsConstructor
@Getter
public class Team {
    private final Club club;
    private final Object key;
    private final String teamName;
    /**
     * the lesser is number the more is team prioritized, 0 for A-team etc.
     * @return
     */
    protected final short priority;
    protected final List<Player> players;
    @Setter
    private League league;
    protected int overallStrength; //TODO generate dynamically


    public Optional<Tackling> predefTackling() {
        return Optional.of(Tackling.EASY);
    }

    public Optional<Marking> predefMarking() {
        return Optional.empty();
    }

    public Optional<CounterAttacks> predefCounterAttacks() {
        return Optional.empty();
    }

    public Optional<PassingFocus> predefPassingFocus() {
        return Optional.empty();
    }

    public Optional<Philosophy> predefPhilosophy() {
        return Optional.empty();
    }

    public Optional<PassingStyle> predefPassingStyle() {
        return Optional.empty();
    }

    /**
     * ranges from ~(180 - 450)
     * @return
     */
    public int strengthOveral() {
        return players.stream()
                .mapToInt(Player::getOverallRating)
                .sum();
    }

    public Optional<League> getLeague() {
        return Optional.ofNullable(league);
    }

    public int strengthInFront() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int strengthInMidfield() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int strengthInBack() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        return key.equals(team.key);
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    @Override
    public String toString() {
        return "Team{" +
                "key=" + key +
                ", overalStrength=" + overallStrength +
                ", players=" + players==null ? "null" : players.size() +
                ", teamName='" + teamName + '\'' +
                ", priority=" + priority +
                '}';
    }
}

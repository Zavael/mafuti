package sk.badand.mafuti.model;

import lombok.*;
import sk.badand.mafuti.model.club.Stadium;
import sk.badand.mafuti.model.club.Team;
import sk.badand.mafuti.model.league.League;
import sk.badand.mafuti.model.match.Player;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Data
public class Club implements Serializable {
    private static final long serialVersionUID = -8101123265621536781L;
    private final String key;
    private String name; //FIXME use either this or teams.get(0).getName... its duplication
    private Manager manager;
    private final List<Team> teams;
    private final List<Staff> staff;
    private Budget budget;
    private Stadium stadium;

    public int getBudgetLeft() {
        return budget.getMoneyAmount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Club club = (Club) o;

        return key.equals(club.key);
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    @Override
    public String toString() {
        return "Club{" +
                "key=" + key +
                ", name='" + name +
                ", manager=" + manager +
                ", teams=" + teams +
                ", staff=" + staff +
                ", budget=" + budget + '\'' +
                '}';
    }

    public int getEstimateValue() {
        return teams.parallelStream()
                .map(team -> team.getPlayers().parallelStream()
                        .map(Player::getEstimateValue)
                        .mapToInt(Integer::intValue)
                        .sum())
                .mapToInt(Integer::intValue)
                .sum();
    }

    public League getMainLeague() {
        return teams.get(0).getLeague().orElse(null);
    }

    public void addTeam(Team team) {
        if (teams.contains(team)) {
            return;
        }
        teams.add(team);
    }
}

package sk.badand.mafuti.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import sk.badand.mafuti.model.club.Stadium;
import sk.badand.mafuti.model.club.Team;
import sk.badand.mafuti.model.league.League;
import sk.badand.mafuti.model.match.Player;

import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
public class Club {
    private final Object key;
    private final String name; //FIXME use either this or teams.get(0).getName... its duplication
    private final Manager manager;
    private final List<Team> teams;
    private final List<Staff> staff;
    @Setter
    private Budget budget;
    @Setter
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
                ", manager=" + manager +
                ", teams=" + teams +
                ", staff=" + staff +
                ", budget=" + budget +
                ", name='" + name + '\'' +
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

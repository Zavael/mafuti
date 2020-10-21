package sk.badand.mafuti.model;

import java.util.List;

/**
 * Created by abadinka.
 */
public class Club{
    private final Object key;
    private final Manager manager;
    private final List<Team> teams;
    private final List<Staff> staff;
    private Budget budget;
    private final String name;

    public Club(Object key, String name, Manager manager, List<Team> teams, List<Staff> staff, Budget budget) {
        this.key = key;
        this.name = name;
        this.manager = manager;
        this.teams = teams;
        this.staff = staff;
        this.budget = budget;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public int getBudget() {
        return budget.getMoneyAmount();
    }

    public Manager getManager() {
        return manager;
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

    public String getName() {
        return name;
    }

    public List<Staff> getStaff() {
        return staff;
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
}

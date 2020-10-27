package sk.badand.mafuti.ui.club;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import sk.badand.mafuti.model.Club;
import sk.badand.mafuti.model.club.Team;
import sk.badand.mafuti.model.match.Player;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ClubPresenter implements Initializable {
    @FXML
    public GridPane clubInfoGrid;
    private SimpleObjectProperty<Club> clubProperty = new SimpleObjectProperty<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clubProperty.addListener((observable, oldVal, newVal) -> {
            clubInfoGrid.add(new Label(newVal.getName()), 1, 1);
            clubInfoGrid.add(new Label(newVal.getManager().getFullName()), 1, 2);
            clubInfoGrid.add(new Label(newVal.getStadium().getName()), 1, 3);
            clubInfoGrid.add(new Label(newVal.getEstimateValue() + " €"), 1, 4);
            clubInfoGrid.add(new Label(newVal.getMainLeague().getName()), 1, 5);
            clubInfoGrid.add(new Label(newVal.getTeams().parallelStream()
                    .map(Team::getPlayers)
                    .flatMap(List::stream)
                    .count() + " players"), 1, 7);
            clubInfoGrid.add(new Label(newVal.getTeams().parallelStream()
                    .map(Team::getPlayers)
                    .flatMap(List::stream)
                    .collect(Collectors.averagingInt(Player::getAge)) + " years"), 1, 8);
            clubInfoGrid.add(new Label(newVal.getTeams().parallelStream()
                    .filter(team -> team.getPriority() == 1)
                    .findFirst()
                    .map(Team::getTeamName)
                    .orElse("")), 1, 9);
            clubInfoGrid.add(new Label(newVal.getTeams().parallelStream()
                    .filter(team -> team.getPriority() == 2)
                    .findFirst()
                    .map(Team::getTeamName)
                    .orElse("")), 1, 10);
        });
    }

    public void setClub(Club club) {
        this.clubProperty.set(club);
    }
}

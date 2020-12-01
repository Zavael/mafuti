package sk.badand.mafuti.ui.menu;

import com.airhacks.afterburner.injection.Injector;
import com.airhacks.afterburner.views.FXMLView;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import sk.badand.mafuti.model.club.Team;
import sk.badand.mafuti.model.match.PlayableMatch;
import sk.badand.mafuti.services.CalendarService;
import sk.badand.mafuti.services.GameService;
import sk.badand.mafuti.services.inject.UsersClubHolder;
import sk.badand.mafuti.ui.club.ClubPresenter;
import sk.badand.mafuti.ui.club.ClubView;
import sk.badand.mafuti.ui.club.staff.StaffView;
import sk.badand.mafuti.ui.club.team.TeamPresenter;
import sk.badand.mafuti.ui.club.team.TeamView;
import sk.badand.mafuti.ui.facilities.academy.AcademyView;
import sk.badand.mafuti.ui.facilities.fitness.FitnessView;
import sk.badand.mafuti.ui.facilities.office.OfficeView;
import sk.badand.mafuti.ui.facilities.stadium.StadiumView;
import sk.badand.mafuti.ui.finances.expenses.ExpensesView;
import sk.badand.mafuti.ui.finances.incomes.IncomesView;
import sk.badand.mafuti.ui.finances.loans.LoansView;
import sk.badand.mafuti.ui.finances.salaries.SalariesView;
import sk.badand.mafuti.ui.finances.summary.SummaryView;
import sk.badand.mafuti.ui.manager.ManagerView;
import sk.badand.mafuti.ui.navigation.AbstractNavigator;
import sk.badand.mafuti.ui.prematch.PrematchView;
import sk.badand.mafuti.ui.timeprogress.TimeprogressView;
import sk.badand.mafuti.ui.training.players.PlayersView;
import sk.badand.mafuti.ui.training.programs.ProgramsView;
import sk.badand.mafuti.ui.training.rehab.RehabView;
import sk.badand.mafuti.ui.world.competitions.CompetitionsView;
import sk.badand.mafuti.ui.world.jobs.JobsView;
import sk.badand.mafuti.util.QuestionDialog;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuPresenter extends AbstractNavigator {
    private static final Logger LOG = Logger.getLogger(MenuPresenter.class.getName());
    @FXML
    public HBox menuHBox;
    @Inject
    CalendarService calendarService;
    @Inject
    GameService gameService;
    @Inject
    UsersClubHolder usersClubHolder;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


    public void processTime() {
        LOG.log(Level.FINE, "processTime");
        if (calendarService.isTeamPlayingToday(usersClubHolder.getClub().getTeams().get(0))) {
            new QuestionDialog("yes or no", Alert.AlertType.CONFIRMATION).showAndWait()
                    .filter(result -> result == ButtonType.OK)
                    .ifPresent(result -> {
                        PlayableMatch managerMatch = calendarService.matchToday(usersClubHolder.getClub().getTeams().get(0)).get();
                        Injector.setModelOrService(PlayableMatch.class, managerMatch);
                        final PrematchView prematchView = new PrematchView();
                        navigator.loadFull(prematchView);
                    });
        } else {
            navigator.loadFull(new TimeprogressView());
        }
    }

    private FXMLView initNewTeamView(String title, int teamPriority) {
        Team team = usersClubHolder.getClub().getTeams().stream()
                .filter(foundteam -> foundteam.getPriority() == teamPriority)
                .findFirst()
                .get();
        final TeamView teamView = new TeamView();
        teamView.getPresenter(presenter -> {
            TeamPresenter teamPresenter = (TeamPresenter) presenter;
            teamPresenter.setTitle(title);
            teamPresenter.setTeam(team);
        });
        return teamView;
    }

    public void showATeam() {
        LOG.log(Level.FINE, "showATeam");
        navigator.load(initNewTeamView("a-team", 0));
    }

    public void showBTeam() {
        LOG.log(Level.FINE, "showBTeam");
        navigator.load(initNewTeamView("b-team",1));
    }

    public void showYouthTeam() {
        LOG.log(Level.FINE, "showYouthTeam");
        navigator.load(initNewTeamView("youth-team", 2));
    }

    public void showStaff() {
        LOG.log(Level.FINE, "showStaff");
        navigator.load(new StaffView());
    }

    public void showPlayers() {
        LOG.log(Level.FINE, "showPlayers");
        navigator.load(new PlayersView());
    }

    public void showOnRehab() {
        LOG.log(Level.FINE, "showOnRehab");
        navigator.load(new RehabView());
    }

    public void showPrograms() {
        LOG.log(Level.FINE, "showPrograms");
        navigator.load(new ProgramsView());
    }

    public void showStadium() {
        LOG.log(Level.FINE, "showStadium");
        navigator.load(new StadiumView());
    }

    public void showOffice() {
        LOG.log(Level.FINE, "showOffice");
        navigator.load(new OfficeView());
    }

    public void showYouthAcademy() {
        LOG.log(Level.FINE, "showYouthAcademy");
        navigator.load(new AcademyView());
    }

    public void showFitnessMedic() {
        LOG.log(Level.FINE, "showFitnessMedic");
        navigator.load(new FitnessView());
    }

    public void showSummary() {
        LOG.log(Level.FINE, "showSummary");
        navigator.load(new SummaryView());
    }

    public void showExpenses() {
        LOG.log(Level.FINE, "showExpenses");
        navigator.load(new ExpensesView());
    }

    public void showIncomes() {
        LOG.log(Level.FINE, "showIncomes");
        navigator.load(new IncomesView());
    }

    public void showSalaries() {
        LOG.log(Level.FINE, "showSalaries");
        navigator.load(new SalariesView());
    }

    public void showLoans() {
        LOG.log(Level.FINE, "showLoans");
        navigator.load(new LoansView());
    }

    public void showCompetitions() {
        LOG.log(Level.FINE, "showCompetitions");
        navigator.load(new CompetitionsView());
    }

    public void showStatistics() {
        LOG.log(Level.FINE, "showStatistics");//TODO rethink, maybe include in competitions somehow
    }

    public void showJobs() {
        LOG.log(Level.FINE, "showJobs");
        navigator.load(new JobsView());
    }

    public void showPersonal() {
        LOG.log(Level.FINE, "showPersonal");
        navigator.load(new ManagerView());
    }

    public void showClub() {
        LOG.log(Level.FINE, "showClub");
        ClubView clubView = new ClubView();
        clubView.getPresenter(presenter -> {
            ClubPresenter clubPresenter = (ClubPresenter) presenter;
            clubPresenter.setClub(usersClubHolder.getClub());
        });
        navigator.load(clubView);
    }

    public void saveGame() {
        LOG.log(Level.FINE, "saveGame");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Mafuti save game files", ".mft")
        );
        File file = fileChooser.showSaveDialog(menuHBox.getParent().getScene().getWindow());
        System.out.println("file:" + file.getAbsolutePath());
        try {
            gameService.saveGame(file);
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "Exception while saving file to {0}, message:{1}", new Object[]{file.getAbsolutePath(), e});
            new QuestionDialog("Cannot save file: " + e.getLocalizedMessage(), Alert.AlertType.ERROR)
                    .showAndWait();
        }
    }

    public void config() {
        LOG.log(Level.FINE, "configuration");
    }

    public void exit() {
        LOG.log(Level.FINE, "exit");
    }
}

package sk.badand.mafuti.ui.editor.club;

import javafx.scene.control.TextField;
import sk.badand.mafuti.ui.navigation.AbstractNavigator;

import java.net.URL;
import java.util.ResourceBundle;

public class ClubPresenter extends AbstractNavigator {

    public TextField clubName;
    public TextField stadiumName;
    public TextField stadiumCapacity;
    public TextField stadiumCity;
//    private final SimpleObjectProperty<Club> clubProperty = new SimpleObjectProperty<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        clubProperty.addListener((observableValue, oldCLub, newClub) -> {
//            if (newClub == null) {
//                return;
//            }
//
//            clubName.setText(newClub.getName());
//        });
    }

//    public void setClub(Club club) {
//        this.clubProperty.setValue(club);
//    }

//    public Club createClub() {
//        Club club = clubProperty.getValue();
//        club.setName(clubName.getText());
//
//        return club;
//    }
}

package sk.badand.mafuti.ui.extensions;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import lombok.Getter;
import sk.badand.mafuti.model.Club;

public class ClubIconVBox extends VBox {
    @Getter
    private Club club;

    public ClubIconVBox(Club club) {
        super();
        getStyleClass().add("club-icon");
        this.club = club;
        setAlignment(Pos.CENTER);
        getChildren().addAll(
                new ImageView("/images/mock_profile_100x100.png"),//TODO replace with correct img
                new Label(club.getName())
        );
    }
}

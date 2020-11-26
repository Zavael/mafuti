package sk.badand.mafuti.ui.factories;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import sk.badand.mafuti.model.league.League;

/**
 * Created by abadinka.
 */
public class ComboBoxLeagueFactory implements Callback<ListView<League>, ListCell<League>> {
    @Override
    public ListCell<League> call(ListView<League> leagueListView) {
        return new ListCell<League>() {

            @Override
            protected void updateItem(League item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(item.getName());
                }
            }
        };
    }
}

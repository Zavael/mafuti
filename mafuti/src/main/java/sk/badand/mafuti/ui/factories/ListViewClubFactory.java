package sk.badand.mafuti.ui.factories;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import sk.badand.mafuti.model.Club;

/**
 * Created by abadinka.
 */
public class ListViewClubFactory implements Callback<ListView<Club>, ListCell<Club>> {
    @Override
    public ListCell<Club> call(ListView<Club> clubListView) {
        return new ListCell<Club>() {
            @Override
            protected void updateItem(Club item, boolean empty) {
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

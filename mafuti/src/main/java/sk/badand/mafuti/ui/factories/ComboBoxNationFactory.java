package sk.badand.mafuti.ui.factories;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import sk.badand.mafuti.model.common.Nation;

/**
 * Created by abadinka.
 */
public class ComboBoxNationFactory implements Callback<ListView<Nation>, ListCell<Nation>> {
    @Override
    public ListCell<Nation> call(ListView<Nation> nationListView) {
        return new ListCell<Nation>() {

            @Override
            protected void updateItem(Nation item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(item.country);
                }
            }
        };
    }
}

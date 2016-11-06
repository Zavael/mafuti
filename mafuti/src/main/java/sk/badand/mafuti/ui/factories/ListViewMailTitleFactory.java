package sk.badand.mafuti.ui.factories;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import sk.badand.mafuti.model.common.Mail;

/**
 * Created by zavael on 6.11.2016.
 */
public class ListViewMailTitleFactory implements Callback<ListView<Mail>, ListCell<Mail>> {

    @Override
    public ListCell<Mail> call(ListView<Mail> param) {
        return new ListCell<Mail>() {

            @Override
            protected void updateItem(Mail item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(item.title());
                }
            }
        };
    }
}

package sk.badand.mafuti.ui.factories;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import sk.badand.mafuti.model.common.Morale;

import java.util.ResourceBundle;

/**
 * Created by abadinka.
 */
public class TableColumnMoraleFactory implements Callback<TableColumn<TableView, Morale>, TableCell<TableView, Morale>> {
    private final ResourceBundle bundle;

    public TableColumnMoraleFactory(ResourceBundle bundle) {
        this.bundle = bundle;
    }

    @Override
    public TableCell<TableView, Morale> call(TableColumn<TableView, Morale> tableViewMoraleTableColumn) {
        return new TableCell<>() {
            @Override
            protected void updateItem(Morale item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    if (bundle.containsKey(item.key)) {
                        setText(bundle.getString(item.key));
                    } else {
                        setText(item.key);
                    }
                }
            }
        };
    }
}
package sk.badand.mafuti.ui.factories;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import sk.badand.mafuti.model.common.Nation;

import java.util.ResourceBundle;

/**
 * Created by abadinka.
 */
public class TableColumnNationFactory implements Callback<TableColumn<TableView, Nation>, TableCell<TableView, Nation>> {
    private final ResourceBundle bundle;

    public TableColumnNationFactory(ResourceBundle bundle) {
        this.bundle = bundle;
    }

    @Override
    public TableCell<TableView, Nation> call(TableColumn<TableView, Nation> tableViewNationTableColumn) {
        return new TableCell<TableView, Nation>() {
            @Override
            protected void updateItem(Nation item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(bundle.getString(item.key));
                }
            }
        };
    }
}

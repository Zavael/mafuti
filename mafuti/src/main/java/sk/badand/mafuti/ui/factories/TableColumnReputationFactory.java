package sk.badand.mafuti.ui.factories;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import sk.badand.mafuti.model.common.Reputation;

import java.util.ResourceBundle;

/**
 * Created by abadinka.
 */
public class TableColumnReputationFactory implements Callback<TableColumn<TableView, Reputation>, TableCell<TableView, Reputation>> {
    private final ResourceBundle bundle;

    public TableColumnReputationFactory(ResourceBundle bundle) {
        this.bundle = bundle;
    }

    @Override
    public TableCell<TableView, Reputation> call(TableColumn<TableView, Reputation> tableViewReputationTableColumn) {
        return new TableCell<TableView, Reputation>() {
            @Override
            protected void updateItem(Reputation item, boolean empty) {
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

package sk.badand.mafuti.ui.factories;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import sk.badand.mafuti.model.common.PersonType;

import java.util.ResourceBundle;

public class TableColumnPersonTypeFactory implements Callback<TableColumn<TableView, PersonType>, TableCell<TableView, PersonType>> {

    private final ResourceBundle bundle;

    public TableColumnPersonTypeFactory(ResourceBundle bundle) {
        this.bundle = bundle;
    }

    @Override
    public TableCell<TableView, PersonType> call(TableColumn<TableView, PersonType> tableViewPersonTypeTableColumn) {
        return new TableCell<>() {
            @Override
            protected void updateItem(PersonType item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    System.out.println("pt: " + item);
                    if (bundle.containsKey(item.bundleKey)) {
                        setText(bundle.getString(item.bundleKey));
                    } else {
                        setText(item.key);
                    }
                }
            }
        };
    }
}

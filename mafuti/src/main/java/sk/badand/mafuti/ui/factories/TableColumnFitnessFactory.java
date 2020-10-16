package sk.badand.mafuti.ui.factories;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import sk.badand.mafuti.model.player.Fitness;

/**
 * Created by abadinka.
 */
public class TableColumnFitnessFactory implements Callback<TableColumn<TableView, Fitness>, TableCell<TableView, Fitness>> {

    @Override
    public TableCell<TableView, Fitness> call(TableColumn<TableView, Fitness> tableViewFitnessTableColumn) {
        return new TableCell<>() {
            @Override
            protected void updateItem(Fitness item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                        setText((int)item.getCondition() + "%");
                }
            }
        };
    }
}

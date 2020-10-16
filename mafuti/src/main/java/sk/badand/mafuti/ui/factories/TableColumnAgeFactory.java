package sk.badand.mafuti.ui.factories;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.time.LocalDate;
import java.time.Period;

/**
 * Created by abadinka.
 */
public class TableColumnAgeFactory implements Callback<TableColumn<TableView, LocalDate>, TableCell<TableView, LocalDate>> {

    @Override
    public TableCell<TableView, LocalDate> call(TableColumn<TableView, LocalDate> tableViewLocalDateTableColumn) {
        return new TableCell<>() {
            @Override
            protected void updateItem(LocalDate item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(Period.between(item, LocalDate.now()).getYears() + " years");
                }
            }
        };
    }
}
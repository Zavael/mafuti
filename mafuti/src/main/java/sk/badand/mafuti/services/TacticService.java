package sk.badand.mafuti.services;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sk.badand.mafuti.model.tactic.Formation;
import sk.badand.mafuti.model.tactic.FormationType;

import java.util.Collections;
import java.util.stream.Stream;

/**
 * Created by abadinka.
 */
public class TacticService {

    private ObservableList<Formation> formations;

    public ObservableList<Formation> getFormations() {
        if (formations == null) {
            formations = FXCollections.observableArrayList(
                    new Formation(
                            FormationType.FORM442,
                            "balanced formation"),
                    new Formation(FormationType.FORM433, "stronger attack, weaker midfield"),
                    new Formation(FormationType.FORM451, "stronger midfield, weaker attack"),
                    new Formation(FormationType.FORM343, "stronger attack, weaker defence"),
                    new Formation(FormationType.FORM352, "stronger midfield, weaker defence"),
                    new Formation(FormationType.FORM541, "stronger defence, weaker attack"),
                    new Formation(FormationType.FORM532, "stronger defence, weaker midfield")
            );
        }

        return formations;
    }
}

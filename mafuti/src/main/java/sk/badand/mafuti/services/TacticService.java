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
                            "no affect"),
                    new Formation(FormationType.FORM343, "stronger attack, weaker defence")
            );
        }

        return formations;
    }
}

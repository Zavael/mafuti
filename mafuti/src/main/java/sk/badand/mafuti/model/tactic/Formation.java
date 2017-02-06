package sk.badand.mafuti.model.tactic;

import sk.badand.mafuti.model.match.PlayerPosition;

import java.util.List;

/**
 * Created by abadinka.
 */
public class Formation {

    private final FormationType formationType;
    public final String affectOnTactic; //TODO

    public Formation(FormationType formationType, String affectOnTactic) {
        this.formationType = formationType;
        this.affectOnTactic = affectOnTactic;
    }

    public String getKey() {
        return formationType.key;
    }

    public String getImagePath() {
        return "/images/formations/" + getKey() + ".png";
    }
}

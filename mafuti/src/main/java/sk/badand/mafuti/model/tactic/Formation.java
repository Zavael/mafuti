package sk.badand.mafuti.model.tactic;

import java.io.Serializable;

/**
 * Created by abadinka.
 */
public class Formation implements Serializable {

    private static final long serialVersionUID = -3721740855844050147L;
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

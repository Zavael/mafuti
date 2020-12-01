package sk.badand.mafuti.model.training;

import sk.badand.mafuti.model.player.PlayerSkill;

import java.io.Serializable;
import java.util.List;

public class TrainingRegime implements Serializable {

    private static final long serialVersionUID = -7912543464050033421L;
    private final TrainingType trainingType;
    private final List<PlayerSkill> affectedSkills;

    public TrainingRegime(TrainingType trainingType, List<PlayerSkill> affectedSkills) {
        this.trainingType = trainingType;
        this.affectedSkills = affectedSkills;
    }

    public List<PlayerSkill> getAffectedSkills() {
        return affectedSkills;
    }

    public String getKey(){
        return trainingType.key; // TODO: 25.10.2016 return localized name
    }

    public String getDescription(){
        return "Explanation of " + getKey() + " skill is reaaaaaalllyyyyyy looooong. Skills" + affectedSkills;
    }

    @Override
    public String toString() {
        return getKey();
    }
}

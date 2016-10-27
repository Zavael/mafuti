package sk.badand.mafuti.model.training;

import sk.badand.mafuti.model.player.PlayerSkill;

import java.util.List;

/**
 * Created by zavael on 24.10.2016.
 */
public class TrainingRegime {

    private final String bundleKey;
    private final List<PlayerSkill> affectedSkills;
    private final String descriptionBundleKey;

    public TrainingRegime(String bundleKey, List<PlayerSkill> affectedSkills, String descriptionBundleKey) {
        this.bundleKey = bundleKey;
        this.affectedSkills = affectedSkills;
        this.descriptionBundleKey = descriptionBundleKey;
    }

    public List<PlayerSkill> getAffectedSkills() {
        return affectedSkills;
    }

    public String getName(){
        return bundleKey; // TODO: 25.10.2016 return localized name
    }

    public String getDescription(){
        return "Explanation of " + getName() + " skill is reaaaaaalllyyyyyy looooong. Skills" + affectedSkills;
    }

    @Override
    public String toString() {
        return getName();
    }
}

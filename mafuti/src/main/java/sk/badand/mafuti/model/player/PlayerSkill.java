package sk.badand.mafuti.model.player;

import sk.badand.mafuti.model.common.PlayerSkillType;
import sk.badand.mafuti.model.common.Skill;

/**
 * Created by zavael on 25.10.2016.
 */
public enum PlayerSkill implements Skill {
    ATTACKING(PlayerSkillType.POSITIONAL, "player.skill.att", "Att"),
    WING(PlayerSkillType.POSITIONAL, "player.skill.wng", "Wng"),
    PLAYMAKING(PlayerSkillType.POSITIONAL, "player.skill.pmg", "Pmg"),
    DEFENDING(PlayerSkillType.POSITIONAL, "player.skill.def", "Def"),
    GOALKEEPING(PlayerSkillType.POSITIONAL, "player.skill.gk", "Gk"),
    PHYSICAL(PlayerSkillType.NATURAL, "player.skill.phy", "Phy"),
    TECHNICAL(PlayerSkillType.NATURAL, "player.skill.tec", "Tec"),
    MENTAL(PlayerSkillType.NATURAL, "player.skill.men", "Men");

    private final PlayerSkillType skillType;
    private final String bundleKey;
    private final String abbreviation;

    private PlayerSkill(PlayerSkillType skillType, String bundleKey, String abbreviation) {
        this.skillType = skillType;
        this.bundleKey = bundleKey;
        this.abbreviation = abbreviation;
    }

    public PlayerSkillType getSkillType() {
        return skillType;
    }

    @Override
    public String getName() {
        return bundleKey; // TODO: 25.10.2016 return localized name
    }

    @Override
    public String getAbbreviation() {
        return abbreviation;
    }
}

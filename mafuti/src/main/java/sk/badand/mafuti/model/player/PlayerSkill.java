package sk.badand.mafuti.model.player;

/**
 * Created by zavael on 25.10.2016.
 */
public enum PlayerSkill {
    ATTACKING(PlayerSkillType.POSITIONAL, "player.skill.att", "Att"),
    WING(PlayerSkillType.POSITIONAL, "player.skill.wng", "Wng"),
    PLAYMAKING(PlayerSkillType.POSITIONAL, "player.skill.pmg", "Pmg"),
    DEFENDING(PlayerSkillType.POSITIONAL, "player.skill.def", "Def"),
    GOALKEEPING(PlayerSkillType.POSITIONAL, "player.skill.gk", "Gk"),
    PHYSICAL(PlayerSkillType.NATURAL, "player.skill.phy", "Phy"),
    TECHNICAL(PlayerSkillType.NATURAL, "player.skill.tec", "Tec"),
    MENTAL(PlayerSkillType.NATURAL, "player.skill.men", "Men");

    private final PlayerSkillType skillType;
    public final String key;
    public final String abbreviation;

    PlayerSkill(PlayerSkillType skillType, String key, String abbreviation) {
        this.skillType = skillType;
        this.key = key;
        this.abbreviation = abbreviation; //TODO refactor to key + "abbrev" ?
    }

    public PlayerSkillType skillType() {
        return skillType;
    }
}

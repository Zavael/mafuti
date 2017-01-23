package sk.badand.mafuti.services;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sk.badand.mafuti.model.player.PlayerSkill;
import sk.badand.mafuti.model.training.TrainingRegime;
import sk.badand.mafuti.model.training.TrainingType;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by abadinka on 24.10.2016.
 */
public class TrainingService {

    private ObservableList<TrainingRegime> predefinedRegimes;

    public List<TrainingRegime> getPredefinedRegimes() {
        if (predefinedRegimes == null) {
            predefinedRegimes = FXCollections.observableArrayList(
                    new TrainingRegime(
                            TrainingType.NATURAL,
                            Arrays.asList(PlayerSkill.PHYSICAL, PlayerSkill.TECHNICAL, PlayerSkill.MENTAL)
                    ),
                    new TrainingRegime(
                            TrainingType.ATTACKING,
                            Arrays.asList(PlayerSkill.PHYSICAL, PlayerSkill.WING, PlayerSkill.ATTACKING)
                    ),
                    new TrainingRegime(
                            TrainingType.CENTRAL,
                            Arrays.asList(PlayerSkill.PLAYMAKING, PlayerSkill.TECHNICAL, PlayerSkill.MENTAL)
                    ),
                    new TrainingRegime(
                            TrainingType.WING,
                            Arrays.asList(PlayerSkill.PHYSICAL, PlayerSkill.TECHNICAL, PlayerSkill.WING)
                    ),
                    new TrainingRegime(
                            TrainingType.DEFENDING,
                            Arrays.asList(PlayerSkill.PHYSICAL, PlayerSkill.DEFENDING, PlayerSkill.MENTAL)
                    ),
                    new TrainingRegime(
                            TrainingType.BALLCONTROL,
                            Arrays.asList(PlayerSkill.ATTACKING, PlayerSkill.TECHNICAL, PlayerSkill.PLAYMAKING)
                    ),
                    new TrainingRegime(
                            TrainingType.GOALKEEPING,
                            Arrays.asList(PlayerSkill.GOALKEEPING, PlayerSkill.DEFENDING, PlayerSkill.TECHNICAL)
                    )
            );

        }
        return predefinedRegimes;
    }
}

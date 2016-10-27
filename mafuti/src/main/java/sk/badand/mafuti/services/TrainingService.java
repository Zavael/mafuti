package sk.badand.mafuti.services;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sk.badand.mafuti.model.player.PlayerSkill;
import sk.badand.mafuti.model.training.TrainingRegime;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by zavael on 24.10.2016.
 */
public class TrainingService {

    private ObservableList<TrainingRegime> predefinedRegimes;

    public List<TrainingRegime> getPredefinedRegimes() {
        if (predefinedRegimes == null) {
            predefinedRegimes = FXCollections.observableArrayList(
                    new TrainingRegime(
                            "training.regime.natural",
                            Arrays.asList(PlayerSkill.PHYSICAL, PlayerSkill.TECHNICAL, PlayerSkill.MENTAL),
                            "training.regime.description.natural"
                    ),
                    new TrainingRegime(
                            "training.regime.attacking",
                            Arrays.asList(PlayerSkill.PHYSICAL, PlayerSkill.WING, PlayerSkill.ATTACKING),
                            "training.regime.description.attacking"
                    ),
                    new TrainingRegime(
                            "training.regime.central",
                            Arrays.asList(PlayerSkill.PLAYMAKING, PlayerSkill.TECHNICAL, PlayerSkill.MENTAL),
                            "training.regime.description.central"
                    ),
                    new TrainingRegime(
                            "training.regime.wing",
                            Arrays.asList(PlayerSkill.PHYSICAL, PlayerSkill.TECHNICAL, PlayerSkill.WING),
                            "training.regime.description.wing"
                    ),
                    new TrainingRegime(
                            "training.regime.defending",
                            Arrays.asList(PlayerSkill.PHYSICAL, PlayerSkill.DEFENDING, PlayerSkill.MENTAL),
                            "training.regime.description.defending"
                    ),
                    new TrainingRegime(
                            "training.regime.ballcontrol",
                            Arrays.asList(PlayerSkill.ATTACKING, PlayerSkill.TECHNICAL, PlayerSkill.PLAYMAKING),
                            "training.regime.description.ballcontrol"
                    ),
                    new TrainingRegime(
                            "training.regime.goalkeeping",
                            Arrays.asList(PlayerSkill.GOALKEEPING, PlayerSkill.DEFENDING, PlayerSkill.TECHNICAL),
                            "training.regime.description.goalkeeping"
                    )
            );

        }
        return predefinedRegimes;
    }
}

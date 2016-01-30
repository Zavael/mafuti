/*
 * Copyright 2014 Andrej Badinka
 */

package sk.badand.mafuti.match.engine.calculators;

import java.util.HashMap;
import sk.badand.mafuti.match.engine.ITeam;
import sk.badand.math.EmpiricDecider;
import sk.badand.math.OddsDecider;
import sk.badand.mafuti.match.engine.actions.controller.TransitionTableController;
import sk.badand.mafuti.match.engine.actions.enums.ActionType;
import sk.badand.mafuti.match.engine.actions.enums.FieldPosition;
import sk.badand.mafuti.match.engine.actions.enums.TeamSide;

/**
 *
 * @author abadinka
 */
public class TeamChancesCalc {
    private static final OddsDecider oddsDecider = new OddsDecider();
    
    private TeamChancesCalc(){
        
    }
    //TODO: finish after Iteam is created
//    ITeam team;
//
//    public TeamChancesCalculator(ITeam team) {
//        this.team = team;
//    }
    
    public static TeamSide decideAttacker(ITeam home, ITeam away){
        return oddsDecider.decideSuccess(0.6) ? TeamSide.HomeTeam : TeamSide.AwayTeam;
    }

    public static boolean attackContinues(ITeam attackingTeam, ITeam defendingTeam, FieldPosition actionPosition) {
        double chance;
        //TODO calculate according to strenghts and ball position
        chance = 0.6;
        return oddsDecider.decideSuccess(chance);
    }

    public static ActionType decideNextDefaultAction(ActionType actionType) {
        HashMap<ActionType, Double> possibleActions = TransitionTableController.getPossibleActions(actionType);
        
        EmpiricDecider<ActionType> empiricDecider = new EmpiricDecider<>(possibleActions);
        ActionType nextAction = empiricDecider.getSuccessfulOption();
        
        
        return nextAction;
    }
}

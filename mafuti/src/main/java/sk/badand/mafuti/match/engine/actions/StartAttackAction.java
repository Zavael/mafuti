/*
 * Copyright 2014 Andrej Badinka
 */
package sk.badand.mafuti.match.engine.actions;

import java.util.logging.Level;
import java.util.logging.Logger;
import sk.badand.mafuti.match.engine.MatchEngineProvider;
import sk.badand.mafuti.match.engine.actions.controller.ActionController;
import sk.badand.mafuti.match.engine.actions.enums.ActionType;
import sk.badand.mafuti.match.engine.calculators.MatchChancesCalc;
import sk.badand.mafuti.match.engine.calculators.TeamChancesCalc;
import sk.badand.statemachine.Machine;

/**
 *
 * @author abadinka
 */
public class StartAttackAction extends AbstractAction {

    private static final Logger LOG = Logger.getLogger(StartAttackAction.class.getName());

    public StartAttackAction(int actionTime, MatchEngineProvider mep) {
        super(actionTime, mep);
    }

    @Override
    public void enterState(Machine machine) {
        if (mep.getLastActions().isEmpty()) {
            LOG.log(Level.FINE, "------------------------------------");
        }
        LOG.log(Level.FINE, "at time: {0}", actionTime);

        mep.setAttacker(TeamChancesCalc.decideAttacker(mep.getHomeTeam(), mep.getAwayTeam()));
        mep.setActionPosition(MatchChancesCalc.decideStartAttackPosition());
    }

    @Override
    public void executeState(Machine machine) {
        LOG.log(Level.FINE, "at time: {0}", actionTime);

        ActionType nextActionType = decideNextAction();
        machine.changeToState(ActionController.generateAction(nextActionType, actionTime, mep));
    }

    @Override
    public void exitState(Machine machine) {
        LOG.log(Level.FINE, "at time: {0}", actionTime);
    }

    private ActionType decideNextAction() {
        return getNextDefaultAction();
    }

    @Override
    public ActionType getActionType() {
        return ActionType.StartAttack;
    }

}

/*
 * Copyright 2014 Andrej Badinka
 */
package sk.badand.mafuti.match.engine.actions;

import java.util.logging.Logger;
import sk.badand.mafuti.match.engine.MatchEngineProvider;
import sk.badand.mafuti.match.engine.actions.enums.ActionType;
import sk.badand.mafuti.match.engine.calculators.TeamChancesCalc;
import sk.badand.statemachine.State;

/**
 *
 * @author abadinka
 */
public abstract class AbstractAction implements State {

    private static final Logger LOG = Logger.getLogger(AbstractAction.class.getName());

    protected final int actionTime;
    protected final MatchEngineProvider mep;
    private AbstractAction nextAction;

    private AbstractAction() {
        this.actionTime = 0;
        this.mep = null;
    }

    protected AbstractAction(int actionTime, MatchEngineProvider mep) {
        this.actionTime = actionTime;
        this.mep = mep;
    }

    protected ActionType getNextDefaultAction() {
        //TODO based on team strenghts calculate probabilities
        ActionType nextDefaultAction = TeamChancesCalc.decideNextDefaultAction(getActionType());
        mep.addLastAction(getActionType());
        return nextDefaultAction;
    }
    
    public abstract ActionType getActionType();
}

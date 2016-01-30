/*
 * Copyright 2014 Andrej Badinka
 */

package sk.badand.mafuti.match.engine.actions;

import java.util.logging.Level;
import java.util.logging.Logger;
import sk.badand.mafuti.match.engine.MatchEngineProvider;
import sk.badand.mafuti.match.engine.actions.controller.ActionController;
import sk.badand.mafuti.match.engine.actions.enums.ActionType;
import sk.badand.statemachine.Machine;

/**
 *
 * @author abadinka
 */
public class YellowCardAction extends AbstractAction {
    private static final Logger LOG = Logger.getLogger(YellowCardAction.class.getName());

    public YellowCardAction(int actionTime, MatchEngineProvider mep) {
        super(actionTime, mep);
    }

    @Override
    public void enterState(Machine machine) {
        LOG.log(Level.FINE, "at time: {0}", actionTime);
    }

    @Override
    public void executeState(Machine machine) {
        LOG.log(Level.FINE, "at time: {0}", actionTime);

        ActionType nextActionType = getNextDefaultAction();
        machine.changeToState(ActionController.generateAction(nextActionType, actionTime, mep));
    }

    @Override
    public void exitState(Machine machine) {
        LOG.log(Level.FINE, "at time: {0}", actionTime);
    }

    @Override
    public ActionType getActionType() {
        return ActionType.YellowCard;
    }
    
}

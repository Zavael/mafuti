/*
 * Copyright 2014 Andrej Badinka
 */
package sk.badand.mafuti.match.engine.actions.controller;

import sk.badand.mafuti.match.engine.MatchEngineProvider;
import sk.badand.mafuti.match.engine.actions.AbstractAction;
import sk.badand.mafuti.match.engine.actions.CenterAction;
import sk.badand.mafuti.match.engine.actions.CornerAction;
import sk.badand.mafuti.match.engine.actions.DribbleAction;
import sk.badand.mafuti.match.engine.actions.FoulAction;
import sk.badand.mafuti.match.engine.actions.FreeKickAction;
import sk.badand.mafuti.match.engine.actions.GoalAction;
import sk.badand.mafuti.match.engine.actions.HandAction;
import sk.badand.mafuti.match.engine.actions.HeaderAction;
import sk.badand.mafuti.match.engine.actions.InjuryAction;
import sk.badand.mafuti.match.engine.actions.LongPassAction;
import sk.badand.mafuti.match.engine.actions.LostPossessionAction;
import sk.badand.mafuti.match.engine.actions.OffsideAction;
import sk.badand.mafuti.match.engine.actions.OutAction;
import sk.badand.mafuti.match.engine.actions.PenaltyAction;
import sk.badand.mafuti.match.engine.actions.RedCardAction;
import sk.badand.mafuti.match.engine.actions.ShortPassAction;
import sk.badand.mafuti.match.engine.actions.ShotAction;
import sk.badand.mafuti.match.engine.actions.ShotBlockedAction;
import sk.badand.mafuti.match.engine.actions.ShotMissedAction;
import sk.badand.mafuti.match.engine.actions.ShotSavedAction;
import sk.badand.mafuti.match.engine.actions.SlidingTackleAction;
import sk.badand.mafuti.match.engine.actions.StartAttackAction;
import sk.badand.mafuti.match.engine.actions.TackleAction;
import sk.badand.mafuti.match.engine.actions.YellowCardAction;
import sk.badand.mafuti.match.engine.actions.enums.ActionType;


/**
 *
 * @author abadinka
 */
public class ActionController {

    public static AbstractAction generateAction(ActionType actionType, int actionTime, MatchEngineProvider mep) {
        switch (actionType) {
            case Center:
                return new CenterAction(actionTime, mep);
            case Corner:
                return new CornerAction(actionTime, mep);
            case Dribble:
                return new DribbleAction(actionTime, mep);
            case Foul:
                return new FoulAction(actionTime, mep);
            case FreeKick:
                return new FreeKickAction(actionTime, mep);
            case Goal:
                return new GoalAction(actionTime, mep);
            case Hand:
                return new HandAction(actionTime, mep);
            case Injury:
                return new InjuryAction(actionTime, mep);
            case LongPass:
                return new LongPassAction(actionTime, mep);
            case LostPossession:
                return new LostPossessionAction(actionTime, mep);
            case Offside:
                return new OffsideAction(actionTime, mep);
            case Out:
                return new OutAction(actionTime, mep);
            case ShortPass:
                return new ShortPassAction(actionTime, mep);
            case Penalty:
                return new PenaltyAction(actionTime, mep);
            case RedCard:
                return new RedCardAction(actionTime, mep);
            case Shot:
                return new ShotAction(actionTime, mep);
            case ShotBlocked:
                return new ShotBlockedAction(actionTime, mep);
            case ShotMissed:
                return new ShotMissedAction(actionTime, mep);
            case ShotSaved:
                return new ShotSavedAction(actionTime, mep);
            case StartAttack:
                return new StartAttackAction(actionTime, mep);
            case YellowCard:
                return new YellowCardAction(actionTime, mep);
            case Tackle:
                return new TackleAction(actionTime, mep);
            case SlidingTackle:
                return new SlidingTackleAction(actionTime, mep);
            case Header:
                return new HeaderAction(actionTime, mep);
            case None:
            case All:
            default:
                return null;
        }
    }
}

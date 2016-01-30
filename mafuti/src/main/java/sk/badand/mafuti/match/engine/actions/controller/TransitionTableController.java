/*
 * Copyright 2014 Andrej Badinka
 */

package sk.badand.mafuti.match.engine.actions.controller;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import sk.badand.mafuti.match.engine.actions.enums.ActionType;

/**
 *
 * @author abadinka
 */
public class TransitionTableController {
    private static final ConcurrentHashMap<ActionType, HashMap<ActionType, Double>> transitionTable;
    
    static {
        transitionTable = new ConcurrentHashMap<>();
        
        HashMap<ActionType, Double> actionMap = new HashMap<>();
        
        actionMap.put(ActionType.None, 1.0);
        transitionTable.put(ActionType.None, new HashMap<>(actionMap));
        
        actionMap.clear();
        actionMap.put(ActionType.ShortPass, 0.1);
        actionMap.put(ActionType.Shot, 0.4);
        actionMap.put(ActionType.Header, 0.3);
        actionMap.put(ActionType.Foul, 0.3);
        actionMap.put(ActionType.Out, 0.1);
        actionMap.put(ActionType.LostPossession, 0.3);
        transitionTable.put(ActionType.Center, new HashMap<>(actionMap));
        
        actionMap.clear();
        actionMap.put(ActionType.ShortPass, 0.1);
        actionMap.put(ActionType.Shot, 0.3);
        actionMap.put(ActionType.Header, 0.4);
        actionMap.put(ActionType.Foul, 0.3);
        actionMap.put(ActionType.Tackle, 0.2);
        actionMap.put(ActionType.Out, 0.1);
        actionMap.put(ActionType.LostPossession, 0.2);
        transitionTable.put(ActionType.Corner, new HashMap<>(actionMap));
        
        actionMap.clear();
        actionMap.put(ActionType.ShortPass, 0.2);
        actionMap.put(ActionType.LongPass, 0.1);
        actionMap.put(ActionType.Center, 0.3);
        actionMap.put(ActionType.Shot, 0.2);
        actionMap.put(ActionType.Tackle, 0.1);
        actionMap.put(ActionType.SlidingTackle, 0.1);
        transitionTable.put(ActionType.Dribble, new HashMap<>(actionMap));
        
        actionMap.clear();
        actionMap.put(ActionType.YellowCard, 0.2);
        actionMap.put(ActionType.RedCard, 0.1);
        actionMap.put(ActionType.Injury, 0.2);
        actionMap.put(ActionType.FreeKick, 0.2);
        actionMap.put(ActionType.Penalty, 0.2);
        transitionTable.put(ActionType.Foul, new HashMap<>(actionMap));
        
        actionMap.clear();
        actionMap.put(ActionType.ShortPass, 0.2);
        actionMap.put(ActionType.LongPass, 0.2);
        actionMap.put(ActionType.Center, 0.3);
        actionMap.put(ActionType.Shot, 0.2); //TODO Depends on ball position
        transitionTable.put(ActionType.FreeKick, new HashMap<>(actionMap));
        
        actionMap.clear();
        actionMap.put(ActionType.None, 1.0);
        transitionTable.put(ActionType.Goal, new HashMap<>(actionMap));
        
        actionMap.clear();
//        actionMap.put(ActionType.YellowCard, 0.2);
//        actionMap.put(ActionType.RedCard, 0.1);
        actionMap.put(ActionType.FreeKick, 0.3);
        actionMap.put(ActionType.Penalty, 0.1);
        transitionTable.put(ActionType.Hand, new HashMap<>(actionMap));
        
        actionMap.clear();
        actionMap.put(ActionType.ShotBlocked, 0.1);
        actionMap.put(ActionType.ShotMissed, 0.2);
        actionMap.put(ActionType.ShotSaved, 0.2);
        actionMap.put(ActionType.Goal, 0.2);
        actionMap.put(ActionType.Out, 0.2);
        actionMap.put(ActionType.LostPossession, 0.2);
        actionMap.put(ActionType.StartAttack, 0.1);
        transitionTable.put(ActionType.Header, new HashMap<>(actionMap));
        
        actionMap.clear();
        actionMap.put(ActionType.YellowCard, 0.3);
        actionMap.put(ActionType.RedCard, 0.2);
        actionMap.put(ActionType.FreeKick, 0.4);
        actionMap.put(ActionType.Penalty, 0.2);
        transitionTable.put(ActionType.Injury, new HashMap<>(actionMap));
        
        actionMap.clear();
        actionMap.put(ActionType.ShortPass, 0.3);
        actionMap.put(ActionType.LongPass, 0.1);
        actionMap.put(ActionType.Dribble, 0.3);
        actionMap.put(ActionType.Center, 0.1);
        actionMap.put(ActionType.Hand, 0.1);
        actionMap.put(ActionType.Shot, 0.3);
        actionMap.put(ActionType.Offside, 0.2);
        actionMap.put(ActionType.Header, 0.1);
        actionMap.put(ActionType.Out, 0.2);
        actionMap.put(ActionType.LostPossession, 0.2);
        transitionTable.put(ActionType.LongPass, new HashMap<>(actionMap));
        
        actionMap.clear();
        actionMap.put(ActionType.None, 0.8);
        actionMap.put(ActionType.StartAttack, 0.2); //TODO depends on tactic - counter attacks
        transitionTable.put(ActionType.LostPossession, new HashMap<>(actionMap));
        
        actionMap.clear();
        actionMap.put(ActionType.FreeKick, 1.0);
        transitionTable.put(ActionType.Offside, new HashMap<>(actionMap));
        
        actionMap.clear();
        actionMap.put(ActionType.None, 0.8);
        actionMap.put(ActionType.StartAttack, 0.1);
        transitionTable.put(ActionType.Out, new HashMap<>(actionMap));
        
        actionMap.clear();
        actionMap.put(ActionType.ShotBlocked, 0.1);
        actionMap.put(ActionType.ShotMissed, 0.2);
        actionMap.put(ActionType.ShotSaved, 0.1);
        actionMap.put(ActionType.Goal, 0.4);
        transitionTable.put(ActionType.Penalty, new HashMap<>(actionMap));
        
        actionMap.clear();
        actionMap.put(ActionType.FreeKick, 0.2);
        actionMap.put(ActionType.Penalty, 0.1); //TODO depends on ball position
        transitionTable.put(ActionType.RedCard, new HashMap<>(actionMap));
        
        actionMap.clear();
        actionMap.put(ActionType.ShortPass, 0.3);
        actionMap.put(ActionType.LongPass, 0.3);
        actionMap.put(ActionType.Dribble, 0.3);
        actionMap.put(ActionType.Center, 0.1);
        actionMap.put(ActionType.Shot, 0.1);
        actionMap.put(ActionType.Out, 0.1);
        actionMap.put(ActionType.LostPossession, 0.1);
        actionMap.put(ActionType.SlidingTackle, 0.2);
        transitionTable.put(ActionType.ShortPass, new HashMap<>(actionMap));
        
        actionMap.clear();
        actionMap.put(ActionType.ShotBlocked, 0.2);
        actionMap.put(ActionType.ShotMissed, 0.2);
        actionMap.put(ActionType.ShotSaved, 0.3);
        actionMap.put(ActionType.Goal, 0.2);
        transitionTable.put(ActionType.Shot, new HashMap<>(actionMap));
        
        actionMap.clear();
        actionMap.put(ActionType.Corner, 0.3);
        actionMap.put(ActionType.Shot, 0.2);
        actionMap.put(ActionType.ShortPass, 0.1);
        actionMap.put(ActionType.Shot, 0.3);
        actionMap.put(ActionType.Foul, 0.2);
        actionMap.put(ActionType.Header, 0.1);
        actionMap.put(ActionType.LostPossession, 0.3);
        transitionTable.put(ActionType.ShotBlocked, new HashMap<>(actionMap));
        
        actionMap.clear();
        actionMap.put(ActionType.None, 1.0);
        transitionTable.put(ActionType.ShotMissed, new HashMap<>(actionMap));
        
        actionMap.clear();
        actionMap.put(ActionType.None, 0.1);
        transitionTable.put(ActionType.ShotSaved, new HashMap<>(actionMap));
        
        actionMap.clear();
        actionMap.put(ActionType.LostPossession, 0.3);
        actionMap.put(ActionType.Out, 0.1);
        actionMap.put(ActionType.Corner, 0.2);
        actionMap.put(ActionType.Foul, 0.3);
        actionMap.put(ActionType.Dribble, 0.1);
        transitionTable.put(ActionType.SlidingTackle, new HashMap<>(actionMap));
        
        actionMap.clear();
        actionMap.put(ActionType.ShortPass, 0.3);
        actionMap.put(ActionType.LongPass, 0.3);
        actionMap.put(ActionType.Dribble, 0.2);
        actionMap.put(ActionType.Center, 0.2);
        transitionTable.put(ActionType.StartAttack, new HashMap<>(actionMap));
        
        actionMap.clear();
        actionMap.put(ActionType.LostPossession, 0.3);
        actionMap.put(ActionType.Out, 0.2);
        actionMap.put(ActionType.Corner, 0.2);
        actionMap.put(ActionType.Foul, 0.3);
        actionMap.put(ActionType.Dribble, 0.1);
        transitionTable.put(ActionType.Tackle, new HashMap<>(actionMap));
        
        actionMap.clear();
        actionMap.put(ActionType.FreeKick, 0.2);
        actionMap.put(ActionType.Penalty, 0.1); //TODO depends on ball position
        transitionTable.put(ActionType.YellowCard, new HashMap<>(actionMap));
    }
    
    public static HashMap<ActionType, Double> getPossibleActions(ActionType forAction){
        if (transitionTable.containsKey(forAction)) {
            return transitionTable.get(forAction);
        }
        return transitionTable.get(ActionType.None);
    }
}

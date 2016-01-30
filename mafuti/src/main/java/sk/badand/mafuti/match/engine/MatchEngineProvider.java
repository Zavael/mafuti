/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.badand.mafuti.match.engine;

import java.util.HashMap;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.collections4.queue.CircularFifoQueue;
import sk.badand.mafuti.builders.MatchCommentaryBuilder;
import sk.badand.mafuti.builders.StatsBuilder;
import sk.badand.mafuti.match.engine.actions.controller.ActionController;
import sk.badand.mafuti.match.engine.actions.enums.ActionType;
import sk.badand.mafuti.match.engine.actions.enums.FieldPosLong;
import sk.badand.mafuti.match.engine.actions.enums.FieldPosWide;
import sk.badand.mafuti.match.engine.actions.enums.FieldPosition;
import sk.badand.mafuti.match.engine.actions.enums.TeamSide;
import sk.badand.mafuti.match.engine.calculators.MatchChancesCalc;
import sk.badand.math.Randomizer;
import sk.badand.statemachine.Machine;

/**
 *
 * @author abadinka
 */
public class MatchEngineProvider extends Observable{
    private static final Logger LOG = Logger.getLogger(MatchEngineProvider.class.getName());

    private final HashMap<TeamSide, ITeam> oponnents;
    private TeamSide attacker;
    private final int MATCH_DURATION = 90;
    private FieldPosition actionPosition;
    private CircularFifoQueue<ActionType> lastActions;
    private CircularFifoQueue<IPlayer> lastPlayersInAction;

    public MatchEngineProvider(ITeam homeTeam, ITeam awayTeam) {
        this.oponnents = new HashMap<>(2);
        oponnents.put(TeamSide.HomeTeam, homeTeam);
        oponnents.put(TeamSide.AwayTeam, awayTeam);
        init();
    }

    private void init() {
        actionPosition = new FieldPosition(FieldPosLong.MidField, FieldPosWide.Center);
        lastActions = new CircularFifoQueue<>(3);
        lastPlayersInAction = new CircularFifoQueue<>(5);
        //Register(ActionType.All, new ReportBuilder());
        //Register(ActionType.All, new StatsBuilder(homeTeam.GetID(), awayTeam.GetID()));
    }

    public void Play() {
        
        addObserver(new MatchCommentaryBuilder());
        addObserver(new StatsBuilder());
        
        LOG.log(Level.FINE, "Starting engine...");
        LOG.log(Level.FINE, "Home team: {0}", oponnents.get(TeamSide.HomeTeam));
        LOG.log(Level.FINE, "Away team: {0}", oponnents.get(TeamSide.AwayTeam));
        int nextActionTime = MatchChancesCalc.nextAttackTime(0);

        Machine matchMachine = new Machine(ActionController.generateAction(ActionType.StartAttack, nextActionTime, this));
        int overtime = new Randomizer().nextRandomInt(4) + 2;
        for (int time = 0; time < MATCH_DURATION + overtime; time++) {
            if (time == nextActionTime) {
                matchMachine.startMachine();
                getLastActions().clear();
                getLastPlayersInAction().clear();
                nextActionTime = MatchChancesCalc.nextAttackTime(time);
                matchMachine = new Machine(ActionController.generateAction(ActionType.StartAttack, nextActionTime, this));
            }
        }
    }

//    private void RegisterMatchEventObserver(IMatchEventObserver observer) {
//        if (observers == null)
//        {
//            observers = new List<IMatchEventObserver>();
//        }
//        if (!observers.Contains(observer))
//        {
//            observers.Add(observer);
//        }
//    }
//    private void UnregisterMatchEventObserver(IMatchEventObserver observer) {
//        if (observers != null)
//        {
//            observers.Remove(observer);
//            if (observers.Count == 0)
//            {
//                observers = null;
//            }
//        }
//    }
    public void setAttacker(TeamSide attacker) {
        this.attacker = attacker;
    }

    public TeamSide getAttacker() {
        return attacker;
    }

    public void setActionPosition(FieldPosition position) {
        this.actionPosition = position;
    }

    public FieldPosition getActionPosition() {
        return actionPosition;
    }

    public TeamSide getDefender() {
        return attacker == TeamSide.HomeTeam
                ? TeamSide.AwayTeam
                : TeamSide.HomeTeam;
    }

    public ITeam getHomeTeam() {
        return oponnents.get(TeamSide.HomeTeam);
    }

    public ITeam getAwayTeam() {
        return oponnents.get(TeamSide.AwayTeam);
    }

    public ITeam getTeam(TeamSide side) {
        return oponnents.get(side);
    }
    
    public void addLastAction(ActionType actionType){
        getLastActions().add(actionType);
    }
    
    public void change(){
        setChanged();
    }

    /**
     * @return the lastActions
     */
    public CircularFifoQueue<ActionType> getLastActions() {
        return lastActions;
    }

    /**
     * @return the lastPlayersInAction
     */
    public CircularFifoQueue<IPlayer> getLastPlayersInAction() {
        return lastPlayersInAction;
    }
}

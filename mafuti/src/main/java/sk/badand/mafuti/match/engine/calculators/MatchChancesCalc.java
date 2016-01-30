/*
 * Copyright 2014 Andrej Badinka
 */
package sk.badand.mafuti.match.engine.calculators;

import sk.badand.mafuti.match.engine.actions.enums.FieldPosLong;
import sk.badand.mafuti.match.engine.actions.enums.FieldPosWide;
import sk.badand.mafuti.match.engine.actions.enums.FieldPosition;
import sk.badand.math.Randomizer;

/**
 *
 * @author abadinka
 */
public abstract class MatchChancesCalc {
    
    private static final Randomizer randomizer = new Randomizer();

    public static int nextAttackTime(int timeFrom) {
        //TODO: upravit podla sil tymov, ak budu rovnako na tom, priklonit sa k mensiemu poctu pripadne podla taktiky
        return timeFrom + randomizer.nextRandomInt(23) + 2;
    }

    public static FieldPosition decideStartAttackPosition() {
        return new FieldPosition(FieldPosLong.MidField, FieldPosWide.Center);
    }
}

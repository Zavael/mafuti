/*
 * Copyright 2014 Andrej Badinka
 */
package sk.badand.mafuti.match.engine.actions.enums;

/**
 *
 * @author abadinka
 */
public class FieldPosition {

    public final FieldPosLong Long;
    public final FieldPosWide Wide;

    public FieldPosition(FieldPosLong Long, FieldPosWide Wide) {
        this.Long = Long;
        this.Wide = Wide;
    }
}

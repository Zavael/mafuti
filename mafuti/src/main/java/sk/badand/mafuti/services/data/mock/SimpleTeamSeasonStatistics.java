/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.services.data.mock;

import sk.badand.mafuti.model.match.TeamSeasonStatistics;

/**
 *
 * @author abadinka
 */
class SimpleTeamSeasonStatistics implements TeamSeasonStatistics {

    public SimpleTeamSeasonStatistics() {
    }

    @Override
    public byte goals() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

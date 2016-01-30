/*
 * Copyright 2014 Andrej Badinka
 */
package sk.badand.mafuti.match.engine;

import sk.badand.mafuti.util.LoggingProperties;

/**
 *
 * @author abadinka
 */
public class Tester {

    public static void main(String[] args) {

        LoggingProperties.setUp();
        
        try {
            generateStructure();
        } catch (Exception e) {
            System.out.println("ex: " + e);
        }

        for (int i = 0; i < 10; i++) {
            MatchEngineProvider mep = new MatchEngineProvider(
                    new ITeam() {
                    },
                    new ITeam() {
                    });
            mep.Play();
        }
    }

    private static void generateStructure() {

    }
}

/*
 * Copyright 2014 Andrej Badinka
 */
package sk.badand.mafuti.match.engine;

import sk.badand.mafuti.services.mock.MockTeam;
import sk.badand.mafuti.util.LoggingProperties;
import sk.badand.math.Randomizer;

/**
 *
 * @author abadinka
 */
public class Tester {

    public static void main(String[] args) {

        System.out.println(Math.round(2 * (8 / (double)(8 + 2))));

//        LoggingProperties.setUp();
//
//        try {
//            generateStructure();
//        } catch (Exception e) {
//            System.out.println("ex: " + e);
//        }
//
//        for (int i = 0; i < 1; i++) {
//            MatchEngineProvider mep = new MatchEngineProvider(new MockTeam(new Randomizer()), new MockTeam(new Randomizer()));
//            mep.Play();
//        }
    }

    private static void generateStructure() {

    }
}

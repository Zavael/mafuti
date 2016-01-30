/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 *
 * @author abadinka
 */
public class LoggingProperties {

    private static final Properties properties = new Properties();
    private static int LOG_SIZE = 10485760;
    private static int LOG_COUNT = 5;
    private static LOG_LEVEL LOG_PROFILE = LOG_LEVEL.TEST;
    private static final String LOG_PROPERTIES_PATH = "/logging.properties";

    static {
        try {
            InputStream is = LoggingProperties.class.getResourceAsStream(LOG_PROPERTIES_PATH);
            LogManager.getLogManager().readConfiguration(is);
//            if (is != null) {
//                properties.load(is);
//                LOG_SIZE = Integer.parseInt(String.valueOf(properties.get("LOG_SIZE")));
//                LOG_COUNT = Integer.parseInt(String.valueOf(properties.get("LOG_COUNT")));
//                LOG_PROFILE = String.valueOf(properties.get("LOG_PROFILE"));
//            } else {
//                System.out.println("logging configuration failed");
//            }
        } catch (IOException ex) {
            Logger.getAnonymousLogger().severe("Could not load default logging.properties file");
            Logger.getAnonymousLogger().severe(ex.getMessage());
        }
    }

    public static void setUp() {
        if (LOG_LEVEL.TEST.id < LOG_PROFILE.id) {
            Logger.getGlobal().setLevel(Level.WARNING);
        }
    }
    
    private static enum LOG_LEVEL {
        DEV((short)0),
        TEST((short)1),
        PROD((short)2);
        
        private final short id;

        private LOG_LEVEL(short id) {
            this.id = id;
        }
    }
}

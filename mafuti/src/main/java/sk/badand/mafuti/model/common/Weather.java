/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.model.common;

import java.io.Serializable;

/**
 *
 * @author abadinka
 */
public enum Weather implements Serializable {
    SUNNY("weather.type.sunny"),
    PARTIAL("weather.type.partialCloudy"),
    CLOUDY("weather.type.cloudy"),
    RAINY("weather.type.rainy");
    
    public final String key;

    Weather(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key;
    }
}

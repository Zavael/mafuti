/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.model.common;

/**
 *
 * @author abadinka
 */
public enum Weather {
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

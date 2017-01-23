/*
 * Copyright 2016 Andrej Badinka
 */
package sk.badand.mafuti.model.common;

/**
 *
 * @author abadinka
 */
public enum Weather {
    SUNNY("sunny"),
    PARTIAL("partially cloudy"),
    CLOUDY("cloudy"),
    RAINY("rainy");
    
    private String uiText;

    Weather(String uiText) {
        this.uiText = uiText;
    }

    @Override
    public String toString() {
        return uiText;
    }
}

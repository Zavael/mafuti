/*
 * Copyright 2014 Andrej Badinka
 */
package sk.badand.mafuti.model.common;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author abadinka
 */
public class Mail implements Serializable {
    private static final long serialVersionUID = -3912923818175978404L;
    //TODO maybe refactor to abstract class and few subclasses
    public final String subjectKey;
    public final String bodyKey;
    public final LocalDate sendDate;
    public final boolean important;
    private boolean hasBeenRead;
    private MailResolution resolution;

    public Mail(String key, LocalDate sendDate, boolean important) {
        this.subjectKey = key + ".subject";
        this.bodyKey = key + ".body";
        this.sendDate = sendDate;
        this.important = important;
    }

    public void setHasBeenRead() {
        this.hasBeenRead = true;
    }

    public void setResolution(MailResolution resolution) {
        this.resolution = resolution;
    }
}

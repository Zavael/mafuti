/*
 * Copyright 2014 Andrej Badinka
 */
package sk.badand.mafuti.model.common;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author abadinka
 */
public class Mail {
    //TODO maybe refactor to abstract class and few subclasses
    private final String message;
    private final String title;
    private final LocalDate sendDate;
    private final boolean important;
    private boolean hasBeenRead;
    private MailResolution resolution;

    public Mail(String title, LocalDate sendDate, boolean important) {
        this.message = title;
        this.title = title;
        this.sendDate = sendDate;
        this.important = important;
    }

    public void setHasBeenRead(boolean hasBeenRead) {
        this.hasBeenRead = hasBeenRead;
    }

    public void setResolution(MailResolution resolution) {
        this.resolution = resolution;
    }

    public String title() {
        return title;
    }

    public String message() {
        return message;
    }
}

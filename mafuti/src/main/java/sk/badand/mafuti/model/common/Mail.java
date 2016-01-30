/*
 * Copyright 2014 Andrej Badinka
 */
package sk.badand.mafuti.model.common;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abadinka
 */
public class Mail {
    //TODO maybe refactor to abstract class and few subclasses
    private final String message;
    private final String title;
    private final LocalDate sendDate;
    private final boolean important;

    public Mail(String message, String title, LocalDate sendDate, boolean important) {
        this.message = message;
        this.title = title;
        this.sendDate = sendDate;
        this.important = important;
    }

    public static List<Mail> getSampleMails(){
        List mails = new ArrayList();
        mails.add(new Mail("Hello there, there is a new transfer leak on the internet.", "New transfer leak!", LocalDate.now(), true));
        mails.add(new Mail("Hello there, there is a new transfer leak on the internet.", "New transfer leak!", LocalDate.now(), true));
        mails.add(new Mail("Hello there, there is a new transfer leak on the internet.", "New transfer leak!", LocalDate.now(), true));
        mails.add(new Mail("Hello there, there is a new transfer leak on the internet.", "New transfer leak!", LocalDate.now(), true));
        mails.add(new Mail("Hello there, there is a new transfer leak on the internet.", "New transfer leak!", LocalDate.now(), true));
        mails.add(new Mail("Hello there, there is a new transfer leak on the internet.", "New transfer leak!", LocalDate.now(), true));
        mails.add(new Mail("Hello there, there is a new transfer leak on the internet.", "New transfer leak!", LocalDate.now(), true));
        return mails;
    }
}

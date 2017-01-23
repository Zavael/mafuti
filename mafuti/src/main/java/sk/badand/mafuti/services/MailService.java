package sk.badand.mafuti.services;

import sk.badand.mafuti.model.common.Mail;

import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by zavael on 6.11.2016.
 */
public class MailService {

    private Collection<Mail> mails = Stream.of(
            new Mail("New transfer offer", LocalDate.now(), true),
            new Mail("Player injured", LocalDate.now(), true),
            new Mail("Financial report of last month", LocalDate.now(), true),
            new Mail("Match delayed", LocalDate.now(), true),
            new Mail("Youth report", LocalDate.now(), true),
            new Mail("Training report", LocalDate.now(), true),
            new Mail("Bank loan closed", LocalDate.now(), true))
            .collect(Collectors.toList());

    public Collection<Mail> getMails() {
        return mails;
    }
}
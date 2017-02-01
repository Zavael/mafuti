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
            new Mail("mail.transfer.offer", LocalDate.now(), true),
            new Mail("mail.player.injury", LocalDate.now(), true),
            new Mail("mail.report.finances", LocalDate.now(), true),
            new Mail("mail.match.delayed", LocalDate.now(), true),
            new Mail("mail.report.youth", LocalDate.now(), true),
            new Mail("mail.report.training", LocalDate.now(), true),
            new Mail("mail.finances.loan.approved", LocalDate.now(), true))
            .collect(Collectors.toList());

    public Collection<Mail> getMails() {
        return mails;
    }
}
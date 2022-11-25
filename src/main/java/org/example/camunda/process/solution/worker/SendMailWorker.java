package org.example.camunda.process.solution.worker;

import java.util.Arrays;

import javax.mail.MessagingException;

import org.example.camunda.process.solution.service.JavaMailer;
import org.example.camunda.process.solution.service.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.camunda.zeebe.spring.client.annotation.JobWorker;
import io.camunda.zeebe.spring.client.annotation.VariablesAsType;

@Component
public class SendMailWorker {

    @Autowired
    private JavaMailer mailService;

    @JobWorker
    public void sendEmail(@VariablesAsType MailData mailData) throws MessagingException  {

        Mail mail = new Mail();

        mail.setMailBody(String.format("Hello %s, "
                + "<br>Best greetings from Camunbankia!"
                + "<br>Your monthly payment will be: <b>%2$,.2f</b>."

                , mailData.getFirstname(), mailData.getCalculatedMonthlyPayment()));

        mail.setMailSubject("Welcome on board!");
        mail.setMailRecipients(Arrays.asList(mailData.getEmailAdress()));
        mailService.sendmail(mail);

    }

}
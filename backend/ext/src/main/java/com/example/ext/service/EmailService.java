package com.example.ext.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            String subject = "Important: Possible Cyberbullying Activity Detected in Your Child’s Online Messages";
            message.setSubject(subject);
            String body = "Dear Parent/Guardian,\n" +
                    "\n" +
                    "We hope this message finds you well.\n" +
                    "\n" +
                    "We would like to inform you that our monitoring system has detected messages sent or received by your child that may contain signs of cyberbullying or harmful language. While not all flagged content indicates actual bullying, we believe it is important to bring this to your attention so you can review the situation.\n" +
                    "\n" +
                    "Please take a moment to have a conversation with your child to ensure their well-being and address any concerns they may have. Their emotional safety and mental health are our top priority.\n" +
                    "\n" +
                    "If you would like a summary of the flagged messages or have questions about our system, feel free to reach out.\n" +
                    "\n" +
                    "Thank you for your attention and continued support.\n" +
                    "\n" +
                    "Sincerely,  \n" +
                    "CareTalk";
            message.setText(body);
            mailSender.send(message);
        } catch (MailException e) {
            log.error(e.getMessage());
        }
    }
}

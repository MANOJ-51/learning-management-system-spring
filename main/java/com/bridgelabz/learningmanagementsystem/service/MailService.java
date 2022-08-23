package com.bridgelabz.learningmanagementsystem.service;

import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * Purpose:Creating MailService
 * @author Manoj
 * @Param  email send
 * Version 1.0
 */
@Component
public class MailService {

    /**
     * Purpose:Creating method to send Email
     * @author Manoj
     * @Param email,subject,body
     */
    public static void send (String toEmail,String subject,String body){
        final String FROM_EMAIL=System.getenv("Email");
        final String PASSWORD = System.getenv("emailpwd");

        Properties properties = new Properties();
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM_EMAIL,PASSWORD);
            }
        };
        javax.mail.Session session = Session.getInstance(properties, authenticator);
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");
            msg.setFrom(new InternetAddress("no_reply@gmail.com", "NoReply"));
            msg.setReplyTo(InternetAddress.parse(System.getenv("Email"), false));
            msg.setSubject(subject, "UTF-8");
            msg.setText(body, "UTF-8");
            msg.setSentDate(new Date());
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
            Transport.send(msg);
            System.out.println("Email Sent Successfully.........");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package com.digicamp.service.impl;

import com.digicamp.service.EmailAuthenticationService;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

    @Service
    public class EmailAuthenticationServiceImplementation implements EmailAuthenticationService {        //this is responsible to send email..
        @Override
        public boolean sendEmail(String message, String subject, String to) {
            boolean flag=false;
            String from="package.handling.iiitb@gmail.com";

            //Variable for gmail
            String host="smtp.gmail.com";

            //get the system properties
            Properties properties = System.getProperties();
            System.out.println("PROPERTIES "+properties);

            //setting important information to properties object
            //host set
            properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.port","465");
            properties.put("mail.smtp.ssl.enable","true");
            properties.put("mail.smtp.auth","true");

            //Step 1: to get the session object..
            Session session=Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, "1234@5678");
                }
            });

            session.setDebug(true);

            //Step 2 : compose the message [text,multi media]
            MimeMessage m = new MimeMessage(session);

            try {
                //from email
                m.setFrom(from);

                //adding recipient to message
                m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

                //adding subject to message
                m.setSubject(subject);

                //adding text to message
                m.setText(message);

                //send
                //Step 3 : send the message using Transport class
                Transport.send(m);

                System.out.println("Sent success...................");
                flag=true;
            }catch (Exception e) {
                e.printStackTrace();
            }
            return flag;
        }
        //this is responsible to send the message with attachment
        private static boolean sendAttach(String message, String subject, String to) {
            boolean flag=false;
            String from="hostel.iiitb1@gmail.com";

            //Variable for gmail
            String host="smtp.gmail.com";

            //get the system properties
            Properties properties = System.getProperties();
            System.out.println("PROPERTIES "+properties);

            //setting important information to properties object

            //host set
            properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.port","465");
            properties.put("mail.smtp.ssl.enable","true");
            properties.put("mail.smtp.auth","true");

            //Step 1: to get the session object..
            Session session=Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, "1btiii.letsoh");
                }
            });

            session.setDebug(true);

            //Step 2 : compose the message [text,multi media]
            MimeMessage m = new MimeMessage(session);
            try {
                //from email
                m.setFrom(from);

                //adding recipient to message
                m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

                //adding subject to message
                m.setSubject(subject);

                //attachement..
                //file path
                String path="C:\\Users\\mehta\\OneDrive\\Desktop\\hello.txt";

                MimeMultipart mimeMultipart = new MimeMultipart();
                //text
                //file
                MimeBodyPart textMime = new MimeBodyPart();
                MimeBodyPart fileMime = new MimeBodyPart();

                try {
                    textMime.setText(message);

                    File file=new File(path);
                    fileMime.attachFile(file);

                    mimeMultipart.addBodyPart(textMime);
                    mimeMultipart.addBodyPart(fileMime);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                m.setContent(mimeMultipart);

                //send
                //Step 3 : send the message using Transport class
                Transport.send(m);
                flag=true;
            }catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Sent success...................");
            return flag;
        }

}

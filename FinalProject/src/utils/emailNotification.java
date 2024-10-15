/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.*;
import java.util.regex.Pattern;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 *
 * @author miaoc
 */
public class emailNotification {
    public static void sendMail(String reciverEmail, String Title, String Content) {
        //Check email valid or not
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";  
        Pattern pat = Pattern.compile(emailRegex);
        if (pat.matcher(reciverEmail).matches() == false){
            return;
        }
        //reciverEmail = "airportnotificationsystem@gmail.com";
        // Recipient's email ID needs to be mentioned.
        
        String to = reciverEmail;
        // Sender's email ID needs to be mentioned
        String from = "airportnotificationsystem@gmail.com";
        
        // Assuming you are sending email from localhost
        String host = "smtp.gmail.com";
        
        // Get system properties
        Properties properties = System.getProperties();
        
        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        
        // Get the Session object.
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("airportnotificationsystem@gmail.com", "hhvjrzpnyywrvrkb");
            }
        });
        
        //session.setDebug(true);
        
        try {
            
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set Subject: header field
            message.setSubject(Title);
            // Now set the actual message
            message.setText(Content);
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
      }
   }
}

package com.email.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
	
	public void sendEmail(String subject,String message,String to)
	{
		//rest of code
		String from = "twestsonu@gmail.com";
		//Variable for gmail
				String host = "smtp.gmail.com";
				
				//get the system properties
				Properties properties = System.getProperties();
				System.out.println("PROPERTIES "+properties);
				
				//setting important information to properties
				
				//host set
				properties.put("mail.smtp.host", host);
				properties.put("mail.smtp.port", "465");
				properties.put("mail.smtp.ssl.enable", "true");
				properties.put("mail.smtp.auth", "true");
				
				//step 1: to get the session object...
				Session session = Session.getInstance(properties, new Authenticator() {

					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						
						return new PasswordAuthentication("twistsonu@gmail.com","#sonu12345" );
					}
					
				});
				
				
				session.setDebug(true);
				
				//Step 2: compose the message[text,multi media]
				MimeMessage mime = new MimeMessage(session);
				
				try {
				 
				//from email
				mime.setFrom();
				
				//adding recipient to message 
				mime.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				
				//adding subject to messsage 
				mime.setSubject(subject);
				
				//adding text to message 
				mime.setText(message);
				
				
				//send
				
				//Step 3 : send the message using Transport class
				Transport.send(mime);
				
				System.out.println("Sent success.....");
				}catch(Exception e) {
					e.printStackTrace();
				}
				
	}

}

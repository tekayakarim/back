package com.pfe.main.serviceImpl;

import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.pfe.main.model.MailModel;
import com.pfe.main.service.MailService;
@Service
public class MailServiceImpl implements MailService {
	


	@Override
	public JavaMailSender getJavaMailSender(String username,String password) {
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost("smtp.gmail.com");
	    mailSender.setPort(587);
	     
	    mailSender.setUsername(username);
	    mailSender.setPassword(password);
	     
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
	     
	    return mailSender;
	}

	@Override
	public String sendSimpleMessage(MailModel mail) {
        SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(mail.getTo()); 
        message.setSubject(mail.getSubject()); 
        message.setText(mail.getBody());
        getJavaMailSender(mail.getMyMail(),mail.getMyPassword()).send(message);
		return "sent";
	}

}

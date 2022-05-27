package com.mycompany.spring_mvc_project_final.service;

import java.text.DecimalFormat;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	@Autowired
	JavaMailSender emailSender;
	
	  public void sendEmail(String from, String to, String subject, String content) {

	     
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom(from);
	        message.setTo(to);
	        message.setSubject(subject);
	        message.setText(content);

	       
	        emailSender.send(message);
	    }
	  
	  public void sendOtpByEmail(HttpServletRequest request, String from, String to) {
		  String otp = new DecimalFormat("000000").format(new Random().nextInt(999999));
			request.getSession().setAttribute("otp", otp);
			sendEmail(from,to,"hello", otp);
	  }
}

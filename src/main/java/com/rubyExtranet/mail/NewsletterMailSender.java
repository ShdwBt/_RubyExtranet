package com.rubyExtranet.mail;

import java.util.ArrayList;
import java.util.List;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.rubyExtranet.model.user.User;

@Service
public class NewsletterMailSender {
	
//	private JavaMailSender javaMailSender;
//
//	@Autowired
//	public NewsletterMailSender(JavaMailSender javaMailSender) {
//		this.javaMailSender = javaMailSender;
//	}
//	
//	@Scheduled(fixedRate = 999999999)
//	public void send() throws MessagingException{
//		List<User> usersList = new ArrayList<User>();
//		// NewsletterMailSender.this.sendNewsletterMail(usersList);
//		sendNewsletterMail(usersList);
//	}
//	public void sendNewsletterMail(List<User> usersList) throws MessagingException{
//		
//		for (User user : usersList){
//			MimeMessage message = javaMailSender.createMimeMessage();
//			MimeMessageHelper helper;
//			
//			helper = new MimeMessageHelper(message, true); // true indicates multipart message
//			helper.setSubject("Test Spring Newsletter");
//			helper.setTo(user.getEmail());
//			helper.setText("Voici la nouvelle newsletter pour vous.", true); // true indicates html
//			
//			// continue using helper object for more functionalities like adding attachments, etc. 
////			if(user.getDepartment() == "IT"){ abcdefghij
////				
////			}
//			// switch for differents cases of departmentTxt;
//			// switch(user.getUserdepartment().getDepartmentText())
//				
//			//parcours d'une arraylsit d'objet departmeent ou de string == departmentText
//			String filePath = "C:/newsletter/newsletter2.jpg";
//	        DataSource sourceFile = new FileDataSource(filePath);
//			helper.addAttachment("Newsletter", sourceFile);
//			
//			javaMailSender.send(message);
//		}
//		
//	}
}

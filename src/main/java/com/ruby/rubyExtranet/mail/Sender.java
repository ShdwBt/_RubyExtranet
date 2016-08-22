package com.ruby.rubyExtranet.mail;

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

import com.ruby.rubyExtranet.model.user.User;
import com.ruby.rubyExtranet.repository.UserRepository;

@Service
public class Sender {
	
	JavaMailSender mailSender;
	
	UserRepository userRepository;
	
	@Autowired
	public Sender(JavaMailSender mailSender, UserRepository userRepository){
		this.mailSender = mailSender;
		this.userRepository = userRepository;
	}
	@Scheduled(fixedRate = 600000000)
	public void send() throws MessagingException {
		List<User> usersList = userRepository.findAll();
		sendMail(usersList);
	}
	
	public void setAttachment(String attachmentPath){

		String filePath = attachmentPath;
		
	}
	
	public void sendMail(List<User> usersList) throws MessagingException{
		
		for (User user : usersList) {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper;
			
			helper = new MimeMessageHelper(message, true); // true indicates multipart message
			helper.setSubject("Test Spring Newsletter");
			helper.setTo(user.getEmail());
			helper.setText("Voici la nouvelle newsletter pour vous.", true); // true indicates html
			
			String department = user.getUserdepartment().getDepartmentText();
			String attachmentPath;
			DataSource sourceAttachment;
			
			switch (department){
				case "DIRECTORATE_GENERAL" :
					attachmentPath = "C:/newsletter/director";
					sourceAttachment = new FileDataSource(attachmentPath);
					helper.addAttachment("Newsletter", sourceAttachment);
					break;
	
				case "ADMINISTRATION" :
					attachmentPath = "C:/newsletter/admin";
					sourceAttachment = new FileDataSource(attachmentPath);
					helper.addAttachment("Newsletter", sourceAttachment);
					break;
	
				case "HR" :
					attachmentPath = "C:/newsletter/hr";
					sourceAttachment = new FileDataSource(attachmentPath);
					helper.addAttachment("Newsletter", sourceAttachment);
					break;
	
				case "COMMERCIAL" :
					attachmentPath = "C:/newsletter/commercial";
					sourceAttachment = new FileDataSource(attachmentPath);
					helper.addAttachment("Newsletter", sourceAttachment);
					break;
	
				case "DELIVERY" :
					attachmentPath = "C:/newsletter/delivery";
					sourceAttachment = new FileDataSource(attachmentPath);
					helper.addAttachment("Newsletter", sourceAttachment);
					break;
	
				case "MARKETING" :
					attachmentPath = "C:/newsletter/marketing";
					sourceAttachment = new FileDataSource(attachmentPath);
					helper.addAttachment("Newsletter", sourceAttachment);
					break;
	
				case "MANUFACTURING" :
					attachmentPath = "C:/newsletter/manufacturing";
					sourceAttachment = new FileDataSource(attachmentPath);
					helper.addAttachment("Newsletter", sourceAttachment);
					break;
	
				case "IT" :
					attachmentPath = "C:/newsletter/it.png";
			        sourceAttachment = new FileDataSource(attachmentPath);
					helper.addAttachment("Newsletter", sourceAttachment);
					break;			
			}

			mailSender.send(message);
			
		}
	}
}

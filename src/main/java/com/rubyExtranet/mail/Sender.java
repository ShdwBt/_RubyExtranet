package com.rubyExtranet.mail;

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
import com.rubyExtranet.repository.UserRepository;

@Service
public class Sender {
	
	JavaMailSender mailSender;
	
	UserRepository userRepository;
	
	@Autowired
	public Sender(JavaMailSender mailSender, UserRepository userRepository){
		this.mailSender = mailSender;
		this.userRepository = userRepository;
	}
	@Scheduled(fixedRate = 5000)
	public void sendBordel() throws MessagingException{
		List<User> usersList = userRepository.findAll();
		sendMailBordel(usersList);
	}
	
	public void sendMailBordel(List<User> usersList) throws MessagingException{
		
		for (User user : usersList) {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper;
			
			helper = new MimeMessageHelper(message, true); // true indicates multipart message
			helper.setSubject("Test Spring Newsletter");
			//helper.setTo("lite.team.asset@gmail.com");
			helper.setTo(user.getEmail());
			helper.setText("Voici la nouvelle newsletter pour vous.", true); // true indicates html
	
			String filePath = "C:/newsletter/newsletter2.jpg";
	        DataSource sourceFile = new FileDataSource(filePath);
			helper.addAttachment("Newsletter", sourceFile);
			
			mailSender.send(message);
		}
	}
}

package com.rubyExtranet.mail;

//import javax.activation.DataSource;
//import javax.activation.FileDataSource;
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//
//import com.rubyExtranet.model.user.CurrentUser;
//import com.rubyExtranet.model.user.currentUser.CurrentUserDetailsService;
//import com.rubyExtranet.service.user.UserService;
//
//@Service
//public class NewsletterCurrentUser {
//	private JavaMailSender javaMailSender;
//	private CurrentUserDetailsService currentUserDetailsService;
//	private UserService userService;
//	private CurrentUser currentUser;
//
//	@Autowired
//	public NewsletterCurrentUser(JavaMailSender javaMailSender, CurrentUserDetailsService currentUserDetailsService
//			, UserService userService, CurrentUser currentUser) {
//		this.javaMailSender = javaMailSender;
//		this.currentUserDetailsService = currentUserDetailsService;
//		this.userService = userService;
//		this.currentUser = currentUser;
//	}
//	
//	//@Scheduled(fixedDelay = 10000)
//	public void sendNewsletterMail() throws MessagingException{
//
//	
//			MimeMessage message = javaMailSender.createMimeMessage();
//			MimeMessageHelper helper;
//			
//			helper = new MimeMessageHelper(message, true); // true indicates multipart message
//			helper.setSubject("Test Spring Newsletter");
//			
//			String currentUserMail = currentUser.getUser().getEmail(); 
//			helper.setTo(currentUserMail);
//			helper.setText("Voici la nouvelle newsletter pour vous.", true); // true indicates html
//
//			
//			String filePath = "C:/newsletter/newsletter2.jpg";
//	        DataSource sourceFile = new FileDataSource(filePath);
//			helper.addAttachment("Newsletter", sourceFile);
//			
//			javaMailSender.send(message);
//				
//	}
//}

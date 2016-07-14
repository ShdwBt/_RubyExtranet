package com.rubyExtranet.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rubyExtranet.mail.NewsletterMailSender;
import com.rubyExtranet.mail.SmtpMailSender;
import com.rubyExtranet.repository.UserRepository;

@Controller
public class NewsletterController {
	
	@Autowired
	NewsletterMailSender newsletterSender;
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/sendNewsletter")
	public void sendMail() throws MessagingException{
		
		newsletterSender.sendNewsletterMail(userRepository.findAll());
	}
}

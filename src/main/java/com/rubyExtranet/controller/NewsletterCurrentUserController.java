package com.rubyExtranet.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rubyExtranet.mail.NewsletterCurrentUser;
import com.rubyExtranet.repository.UserRepository;

@Controller
public class NewsletterCurrentUserController {
	@Autowired
	NewsletterCurrentUser newsletter;
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/sendNewsletter")
	
	public void sendMail() throws MessagingException{
		
		newsletter.sendNewsletterMail();
	}
}

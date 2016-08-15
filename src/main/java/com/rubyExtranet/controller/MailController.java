package com.rubyExtranet.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.rubyExtranet.mail.SmtpMailSender;

@Controller
public class MailController {
	
//	@Autowired
//	SmtpMailSender mailSender;
//	
//	@RequestMapping("/sendMail")
//	public void sendMail() throws MessagingException{
//		
//		mailSender.send("lite.team.asset@gmail.com", "Test mail Spring", "AssetBot");
//	}
}

package com.ruby.service;

import com.ruby.domain.User;
import javax.mail.MessagingException;

import java.util.List;

public interface MailSenderService {

    public void send()throws MessagingException ;
    public void setAttachment(String attachmentPath);
    public void sendMail(List<User> usersList) throws MessagingException;
}


package com.ruby.service;

import com.ruby.domain.User;
import com.ruby.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.internet.MimeMessage;
import javax.mail.MessagingException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MailMailSenderServiceImpl implements MailSenderService {
    @Autowired
    JavaMailSender mailSender;

    @Autowired
    UserRepository userRepository;

    @Override
    @Scheduled(fixedRate = 600000000)
    public void send() throws MessagingException{
        List<User> usersList = userRepository.findAll();
        sendMail(usersList);
    }

    @Override
    public void setAttachment(String attachmentPath) {
        String filePath = attachmentPath;
    }

    @Override
    public void sendMail(List<User> usersList) throws MessagingException {
        for (User user : usersList) {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper;

            helper = new MimeMessageHelper(message, true); // true indicates multipart message
            helper.setSubject("Test Spring Newsletter");
            helper.setTo(user.getEmail());
            helper.setText("Voici la nouvelle newsletter pour vous.", true); // true indicates html

            String department = user.getDepartment().getText();
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

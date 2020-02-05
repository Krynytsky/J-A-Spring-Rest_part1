package com.spring.lesson3.rest_part1.services;

import com.spring.lesson3.rest_part1.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
@PropertySource("classpath:application.properties")

public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private Environment environment;

    public void send (User user){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        try {
            mimeMessage.setFrom(new InternetAddress(environment.getProperty("spring.mail.username")));
            mimeMessageHelper.setTo(user.getEmail());
            mimeMessageHelper.setText("<p> Try to send message from java</p>",true);
        } catch (MessagingException e){
            e.printStackTrace();
        }
        javaMailSender.send(mimeMessage);

    }
}

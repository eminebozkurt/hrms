package com.hrms.hrms.core.emailSender;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class EmailService implements EmailSender{

    private final JavaMailSender javaMailSender;

    //@Value("${spring.mail.username}")
    //private final String from;

    @Override
    @Async
    public void send(String to, String email) {
        try {
            MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,"utf-8");

            helper.setFrom("system-mail@mail.com");
            helper.setTo(to);
            helper.setSubject("Verification mail");
            helper.setText(email,true);

            this.javaMailSender.send(mimeMessage);

        }catch (MessagingException e){
            throw new IllegalStateException("Exception of sending email!");
        }
    }
}

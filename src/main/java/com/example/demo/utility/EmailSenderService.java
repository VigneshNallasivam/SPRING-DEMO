package com.example.demo.utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
@Component
public class EmailSenderService
{
    @Autowired
    private JavaMailSender mailSender;
    public void sendEmail(String toEmail, String subject, String body)
    {
        SimpleMailMessage objx =new SimpleMailMessage();
        objx.setFrom("vickyshanestark@gmail.com");
        objx.setTo(toEmail);
        objx.setText(body);
        objx.setSubject(subject);
        mailSender.send(objx);
        System.out.println("Mail sent Successfullly!!");
    }
}

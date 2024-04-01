package com.ecommerce.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender sender;
    @Value("${spring.mail.username}")
    private String systemEmail;

    public void passwordRecoverCode(String email) {
        String code = RandomStringUtils.randomAlphanumeric(6);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(systemEmail);
        message.setTo(email);
        message.setSubject("Password Recover");
        message.setText("""
                       Your confirmation code is:\s
                     
                       %s\s           
                """.formatted(code));
        sender.send(message);
    }
}

package com.hasanalmunawr.ImplemetationSpringBootEmailSender.service;

import jakarta.mail.MessagingException;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;
import java.security.SecureRandom;

import static com.hasanalmunawr.ImplemetationSpringBootEmailSender.utils.EmailUtil.getMessageEmail;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String senderEmail;


    public void sendEmail2(
            String username,
            String confirmationUrl,
            String recipientEmail
    ) {

        try {
            String code = generateActivationCode(6);
            String htmlContent = getMessageEmail(username, code, confirmationUrl);
            MimeMessage message = mailSender.createMimeMessage();

            message.setFrom(senderEmail);
            message.setRecipients(MimeMessage.RecipientType.TO, recipientEmail);
            message.setSubject("Account Activation"); // Set your email subject here
            message.setContent(htmlContent, "text/html; charset=utf-8");
            mailSender.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }



//    TO CREATE RANDOM CODE
    private String generateActivationCode(int lengthCode) {
        String characters = "0123456789";
        StringBuilder codeBuilder = new StringBuilder();

        SecureRandom secureRandom = new SecureRandom();

        for (int i = 0; i < lengthCode; i++) {
            int randomIndex = secureRandom.nextInt(characters.length());
            codeBuilder.append(characters.charAt(randomIndex));
        }

        return codeBuilder.toString();
    }
}

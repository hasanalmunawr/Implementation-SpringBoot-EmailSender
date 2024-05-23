package com.hasanalmunawr.ImplemetationSpringBootEmailSender.controller;

import com.hasanalmunawr.ImplemetationSpringBootEmailSender.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    String username = "hasan Almunawr";
    String email = "hasanalmunawar9@gmail.com";
    String link = "https://ibox.co.id/product/macbook-pro-m2-14-inci-2023-ib";


    @PostMapping
    public void post() {
        emailService.sendEmail2(username, link, email);
    }
}

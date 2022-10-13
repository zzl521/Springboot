package com.school.covid.service;

import org.springframework.mail.javamail.JavaMailSender;

public interface javaMailService {

    public String senEmail(String receiver);
}

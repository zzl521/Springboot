package com.school.covid.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.mail.internet.MimeMessage;
import java.io.InputStream;

@Component
public class JavaMailSenderConfig {
//已使用框架集成的邮件发送对象
}

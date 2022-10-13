package com.school.covid.service.impl;

import com.school.covid.service.javaMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class javaMailImpl implements javaMailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Override
    public String senEmail(String receiver) {
        SimpleMailMessage message=new SimpleMailMessage();
        message.setText("数据来源:假期返校信息填报，来自:上海,风险程度:高！请及时登录系统筛选排查"); //
        message.setSubject("疫情预警通知:");
        message.setFrom("860786071@qq.com"); //设置发送方qq，不设置报错501
        message.setTo(receiver); //于下一致
        message.setCc("2503963481@qq.com"); //接收方qq
        message.setBcc("2503963481@qq.com"); //接收方qq
        javaMailSender.send(message);
        return null;
    }
}

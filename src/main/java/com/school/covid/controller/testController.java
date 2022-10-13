package com.school.covid.controller;

import com.school.covid.constant.Covid_Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class testController {

    @Autowired
    private RedisTemplate redisTemplate;
    @RequestMapping("/t")
    public void test(){

        String s= (String) redisTemplate.opsForValue().get(Covid_Constant.NEWS);
        System.out.println(s);
    }
}

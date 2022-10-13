package com.school.covid.controller;

import com.school.covid.constant.Covid_Constant;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/now")
public class CovidMapController {
    @Autowired
    private RedisTemplate redisTemplate;


    @SneakyThrows
    @GetMapping("/confirm")
    @ResponseBody
    public String gateDatNews(){
       return redisTemplate.opsForValue().get(Covid_Constant.DATE).toString();

    }
}

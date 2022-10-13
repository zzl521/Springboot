package com.school.covid.utilsAmdtimer;

import cn.hutool.http.HttpUtil;
import com.school.covid.constant.Covid_Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@EnableScheduling
public class CovidTask {

    @Autowired
    private RedisTemplate redisTemplate;
    @Scheduled(fixedDelay = 1000*60*60)
    public void CovidNewsData(){
        String message= HttpUtil.get("https://c.m.163.com/ug/api/wuhan/app/data/list-total?t="+System.currentTimeMillis());
        redisTemplate.opsForValue().set(Covid_Constant.DATE,message);
        //NewsList newsList=restTemplate.getForObject("http://api.tianapi.com/ncov/index?key=7ddcf8f797a5113b5150baf3292e8d3f",NewsList.class);
        String news=HttpUtil.get("http://api.tianapi.com/ncov/index?key=7ddcf8f797a5113b5150baf3292e8d3f");
        redisTemplate.opsForValue().set(Covid_Constant.NEWS,news);

    }
}

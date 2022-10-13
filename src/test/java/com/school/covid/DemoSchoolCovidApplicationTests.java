package com.school.covid;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.school.covid.constant.Check_Constant;
import com.school.covid.mapper.HomeMapper;
import com.school.covid.mapper.SelectHealthClockMapper;
import com.school.covid.mapper.SelectSchoolAndHomeMapper;
import com.school.covid.service.HomeService;
import com.school.covid.service.javaMailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SpringBootTest
class DemoSchoolCovidApplicationTests {
////    @Autowired
////    private RestTemplate restTemplate;
      @Autowired
      private HomeMapper homeMapper;
////
////    @Test
////    public void http() {
////
////       NewsList newsList = restTemplate.getForObject("http://api.tianapi.com/ncov/index?key=7ddcf8f797a5113b5150baf3292e8d3f", NewsList.class);
////
////        System.out.println(newsList);
////    }
    @Autowired
    private SelectSchoolAndHomeMapper selectMapper;
    @Autowired
    private HomeService homeService;
    @Autowired
    private SelectHealthClockMapper selectHealthClockMapper;
    @Autowired
    private javaMailService javaMailService;
    @Test
    void contextLoads() {
//        List<SchoolAndHome> schoolAndHomes = selectMapper.queryAll();
//        System.out.println(schoolAndHomes);

//        QueryWrapper<Home> wrapper = new QueryWrapper<>();
//        query query = new query();
//        if (StringUtils.isNotBlank(query.getBegin())) {
//            System.out.println(query.getBegin());
//            wrapper.ge("writetime",query.getBegin());
//        }
//        if (StringUtils.isNotBlank(query.getEnd())) {
//            wrapper.le("writetime",query.getEnd());
//        }
//
//        homeMapper.selectList(wrapper);
//        //return Result.ok(page);
        System.out.println( selectMapper.queryAllTemp());


    }
    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void CheckCovidAndNativeMessage() {
      //  redisTemplate.opsForValue().get(Check_Constant.Health_temp);

        //JSONArray health_risk = JSONArray.parseArray(redisTemplate.opsForValue().get(Check_Constant.Health_temp));
       // JSONObject jsonObject = health_risk.getJSONObject(0);
        //javaMailService.senEmail("250396");
//        for (int i = 0; i < health_temp.length(); i++) {
//            int result = Integer.parseInt((String) jsonObject.get("temp"));
//            System.out.println("程序运行");
//            System.out.println(result);
//
//            if (result >= 37) {
//                javaMailService.senEmail("2503963481@qq.com");
//            }

            //System.out.println(redisTemplate.opsForValue().get(Check_Constant.Health_temp));
        float leave_temp=37;
        List<Integer> health_temp = (List<Integer>) redisTemplate.opsForValue().get(Check_Constant.Health_temp);
        List<Integer> list=new ArrayList<>(health_temp);
        for (int i=0;i<list.size();i++){
         if (Double.valueOf(String.valueOf(list.get(i)))>=leave_temp){
             javaMailService.senEmail("2503963481@qq.com");
         }
        }
        }

    }


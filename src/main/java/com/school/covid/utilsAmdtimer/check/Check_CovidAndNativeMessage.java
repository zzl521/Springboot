package com.school.covid.utilsAmdtimer.check;


import com.school.covid.constant.Check_Constant;
import com.school.covid.service.javaMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@EnableScheduling
public class Check_CovidAndNativeMessage {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private javaMailService javaMailService;
    @Scheduled(fixedDelay = 1000*60*60)
    public void CheckCovidAndNativeMessage() {
        //查询到
        //检查打卡数据，包含risk，temp风险地区、体温数据自检
        StringBuffer stringBuffer=new StringBuffer();
        String health_risk=redisTemplate.opsForValue().get(Check_Constant.Health).toString();
        stringBuffer.append(health_risk);

        if (stringBuffer.toString().contains("1")){//若包含一则发送提醒消息
            javaMailService.senEmail("2503963481@qq.com");
        }
        float leave_temp=37;
        List<Integer> health_temp = (List<Integer>) redisTemplate.opsForValue().get(Check_Constant.Health_temp);
        List<Integer> list_temp=new ArrayList<>(health_temp);
        for (int i=0;i<list_temp.size();i++){
            if (Double.valueOf(String.valueOf(list_temp.get(i)))>=leave_temp){
                javaMailService.senEmail("2503963481@qq.com");
            }
        }


//        JSONArray health_risk = JSONArray.parseArray(health_temp);
//        JSONObject jsonObject = health_risk.getJSONObject(0);
        //javaMailService.senEmail("250396");
//        for (int i=0;i<health_temp.length();i++){
//           int result= Integer.parseInt((String) jsonObject.get("temp"));
//            System.out.println("程序运行");
//            System.out.println(result);
//
//           if (result>=37){
//               javaMailService.senEmail("2503963481@qq.com");
//           }
//        }





    }




}

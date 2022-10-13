package com.school.covid.utilsAmdtimer.check;

import com.school.covid.constant.Check_Constant;
import com.school.covid.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class CovidAndNativeMessageWrite {

    @Autowired private RedisTemplate redisTemplate;
    @Autowired private SelectHealthClockMapper selectHealthClock;
    @Autowired private SelectIn_doorMapper selectIn_door;
    @Autowired private SelectOut_doorMapper selectOut_door;
    @Autowired private SelectSchoolAndHomeMapper selectMapper;
    @Autowired private SelectSchool_homeMapper selectSchool_homeMapper;
    @Autowired private SelectTeacherMapper selectTeacherMapper;
    @Scheduled(fixedDelay = 1000*60*60)
    public void CovidAndNativeMessageWrite(){

        //日常获取打卡状态
        redisTemplate.opsForValue().set(Check_Constant.Health,selectHealthClock.selectHealthClock_risk());
        //打卡体温
        redisTemplate.opsForValue().set(Check_Constant.Health_temp,selectHealthClock.selectHealth_temp());

        //进门地点
        redisTemplate.opsForValue().set(Check_Constant.In_door,selectIn_door.selectIn_door_place());
        //体温
        redisTemplate.opsForValue().set(Check_Constant.In_door_temp,selectIn_door.selectIn_door_temp());

        //出门体温
        redisTemplate.opsForValue().set(Check_Constant.Out_door_temp,selectOut_door.selectOut_door());



        redisTemplate.opsForValue().set(Check_Constant.SchoolAndHome_temp,selectMapper.queryAllTemp());

        //地点查询
        redisTemplate.opsForValue().set(Check_Constant.SchoolAndHome_all,selectMapper.queryAll());

        redisTemplate.opsForValue().set(Check_Constant.SchoolAndHome_risk,selectMapper.queryAllRisk());

        redisTemplate.opsForValue().set(Check_Constant.School_home,selectSchool_homeMapper.queryAll());
        //教师查询
        redisTemplate.opsForValue().set(Check_Constant.Teacher_risk,selectTeacherMapper.selectTeacher_risk());
        redisTemplate.opsForValue().set(Check_Constant.Teacher_temp,selectTeacherMapper.selectTeacher_temp());
    }
}

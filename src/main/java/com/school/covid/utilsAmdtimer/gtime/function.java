package com.school.covid.utilsAmdtimer.gtime;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class function {
    //获取当前时间

    public static String getNowTime(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        return simpleDateFormat.format(date);
    }
    //获取当前七天之前的时间
    public static String getBeforeTime(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.DATE,-7);
        return simpleDateFormat.format(calendar.getTime());
    }
}

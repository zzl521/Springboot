package com.school.covid.entity.day;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.school.covid.utilsAmdtimer.gtime.function;


public class query {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String Begin;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String End;


    public String getBegin() {


        return function.getBeforeTime();
    }
    //当前时间减去七天
    public void setBegin(String begin) {

        Begin = begin;
    }

    public String getEnd() {
        return End=function.getNowTime();
    }

    public void setEnd(String end) {
        End = end;
    }

}

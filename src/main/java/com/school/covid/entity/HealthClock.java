package com.school.covid.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.school.covid.entity.Enum.GenderEnum;
import com.school.covid.entity.Enum.ImpEnum;
import lombok.Data;

import java.util.Date;

//用于记录打卡信息
@Data
public class HealthClock {

    @TableId(type = IdType.AUTO)
    private  Long  id ;
    private  String name;
    private GenderEnum sex; //性别
    private Long  card;
    private  float temp;
    private String depart;
    private  String state; //居家- 请假，在校,隔离
    private ImpEnum risk;// 风险地区记录
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date writetime; //填写时间

}

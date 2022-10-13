package com.school.covid.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.school.covid.entity.Enum.GenderEnum;
import com.school.covid.entity.Enum.ImpEnum;
import lombok.Data;

import java.util.Date;

@Data
//返校信息(假期结束返校填写)
public class School {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private GenderEnum sex; //性别
    private Long card;  //学号 @标识身份
    private String depart; //院系
    private float temp; //体温
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date gate; //出行时间
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date wate; //离家时间
    private String Travel; //出行方式
    private String place; //出发地点
    private String destination;//目的地
    private String Train; //车次
    private String home; //家庭所在省份
    private ImpEnum risk;// 风险地区记录
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date writetime; //填写时间
    // private Date bDate;

}
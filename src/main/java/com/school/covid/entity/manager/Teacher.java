package com.school.covid.entity.manager;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.school.covid.entity.Enum.GenderEnum;
import com.school.covid.entity.Enum.ImpEnum;
import lombok.Data;

import java.util.Date;

@Data
public class Teacher {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private GenderEnum sex;
    private String depart;
    private String work;
    private float temp;
    private String state;
    private ImpEnum risk;// 风险地区记录
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date writetime; //填写时间
}

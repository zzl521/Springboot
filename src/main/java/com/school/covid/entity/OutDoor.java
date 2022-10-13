package com.school.covid.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.school.covid.entity.Enum.GenderEnum;
import lombok.Data;

import java.util.Date;

@Data
public class OutDoor {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private GenderEnum sex; //性别
    private  Long card;
    private String depart;
    private float temp; //温度
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date writetime; //填写时间

}

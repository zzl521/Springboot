package com.school.covid.entity.waring;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.school.covid.entity.Enum.GenderEnum;
import com.school.covid.entity.Enum.ImpEnum;
import lombok.Data;

import java.util.Date;

@Data
public class SendConfig {
    @TableId(type = IdType.AUTO)
    private  Long  id ;
    private  String phone;
    private String email;
    private Long tall;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date writetime; //填写时间

}

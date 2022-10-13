package com.school.covid.entity.select;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class HealthClock_risk_temp implements Serializable {
    @TableId(type = IdType.AUTO)
    private String temp;
    //private String risk;
}

package com.school.covid.entity.select;

import com.school.covid.entity.Enum.ImpEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class SchoolAndHome implements Serializable {

    private String Travel;

    private float temp;

    private String place;

    private ImpEnum risk;

    private String destnation;


}

package com.school.covid.entity.HttpData;

import lombok.Data;

//疫情综合父对象
@Data
public class Desc {

    private String currentConfirmedCount;  //现存确诊人数

    private String seriousCount;  //现存无症状人数

    private String currentConfirmedIncr; //相比较昨日确诊人数

}

package com.school.covid.entity.HttpData;

import lombok.Data;

import java.util.List;

@Data
//疫情新闻接口内部数据封装---便于axios加载渲染
public class news {

    private  String id;
    private  String pubDate;
    private  String pubDateStr;
    private  String title;
    private String summary;
    private String infoSource;
    private String sourceUrl;


}

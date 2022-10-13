package com.school.covid.entity.HttpData;

import lombok.Data;

import java.util.List;

@Data
//疫情新闻接口数据封装
public class NewsList {
    private Integer code;
    private String msg;
    private List<NewsListData> newslist;
}

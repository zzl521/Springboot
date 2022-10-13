package com.school.covid.entity.HttpData;

import lombok.Data;

import java.util.List;

@Data
public class NewsListData {
    private List<news> news;
    private Object desc;
    private Object riskarea;
}

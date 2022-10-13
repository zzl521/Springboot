package com.school.covid.controller;

import com.school.covid.entity.HttpData.NewsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/covid")
public class CovidResourceController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/news")
    @ResponseBody
    public List gateDatNews(){
        NewsList newsList=restTemplate.getForObject("http://api.tianapi.com/ncov/index?key=7ddcf8f797a5113b5150baf3292e8d3f",NewsList.class);

        return newsList.getNewslist();
    }
}

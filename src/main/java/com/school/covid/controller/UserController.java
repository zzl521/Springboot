package com.school.covid.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    //获取接口数据
    @RequestMapping("/get")
    public String get(){
        return "get";
    }
    //提交接口数据
    @RequestMapping("/post")
    public String post(){
        return "post";
    }
    //更新接口数据
    @RequestMapping("/put")
    public String put(){
        return "put";
    }
    //删除接口数据
    @RequestMapping("/delete")
    public String delete(){
        return "delete";
    }



}

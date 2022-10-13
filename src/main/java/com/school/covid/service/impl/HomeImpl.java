package com.school.covid.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.school.covid.entity.Home;
import com.school.covid.mapper.HomeMapper;
import com.school.covid.service.HomeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//假期离校数据------》回家
@Service
public class HomeImpl extends ServiceImpl<HomeMapper, Home> implements HomeService {
    @Autowired
    private HomeMapper mapper;

    @Override
    public List<Home> getAll() {
        List<Home> list;

        list=mapper.selectList(null);

        return list;
    }
}

package com.school.covid.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.school.covid.entity.Home;
import com.school.covid.entity.School;
import com.school.covid.mapper.HomeMapper;
import com.school.covid.mapper.SchoolMapper;
import com.school.covid.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

//假期饭校数据 ----》回校
@Service
public class SchoolImpl extends ServiceImpl<SchoolMapper, School> implements SchoolService {
    @Autowired
    private SchoolMapper schoolMapper;

    @Override
    public List<School> getAll() {
        List<School> list;

        list=schoolMapper.selectList(null);

        return list;
    }
}

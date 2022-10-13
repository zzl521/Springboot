package com.school.covid.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.school.covid.entity.School;

import java.util.List;

public interface SchoolService extends IService<School> {
    public List<School> getAll();
}

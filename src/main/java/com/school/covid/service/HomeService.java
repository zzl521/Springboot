package com.school.covid.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.school.covid.entity.Home;

import java.util.List;

public interface HomeService extends IService<Home> {
   public List<Home> getAll();
}

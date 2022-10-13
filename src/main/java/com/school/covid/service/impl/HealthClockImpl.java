package com.school.covid.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.school.covid.entity.HealthClock;
import com.school.covid.mapper.HealthClockMapper;
import com.school.covid.service.HealthClockService;
import org.springframework.stereotype.Service;

@Service
public class HealthClockImpl extends ServiceImpl<HealthClockMapper, HealthClock> implements HealthClockService {


}

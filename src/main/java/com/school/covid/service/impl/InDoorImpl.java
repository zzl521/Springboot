package com.school.covid.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.school.covid.entity.InDoor;
import com.school.covid.mapper.InDoorMapper;
import com.school.covid.service.InDoorService;
import org.springframework.stereotype.Service;

@Service
public class InDoorImpl extends ServiceImpl<InDoorMapper, InDoor> implements InDoorService{

}

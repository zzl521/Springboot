package com.school.covid.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.school.covid.entity.waring.SendConfig;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public interface WaringConfigMapper extends BaseMapper<SendConfig> {
}

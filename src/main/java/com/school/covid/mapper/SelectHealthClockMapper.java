package com.school.covid.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.school.covid.entity.select.HealthClock_risk_temp;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface SelectHealthClockMapper extends BaseMapper<HealthClock_risk_temp> {

    @Select("select risk from health_clock")
    List<HealthClock_risk_temp> selectHealthClock_risk();

    @Select("select temp from health_clock")
    List<Integer> selectHealth_temp();

}



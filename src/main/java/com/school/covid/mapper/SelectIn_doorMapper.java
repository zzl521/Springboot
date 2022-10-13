package com.school.covid.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.school.covid.entity.select.In_door;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SelectIn_doorMapper extends BaseMapper<In_door> {
    @Select("select place from in_door")
    List<In_door> selectIn_door_place();
    @Select("select temp from in_door")
    List<Integer> selectIn_door_temp();

}

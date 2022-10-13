package com.school.covid.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.school.covid.entity.select.Out_door;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SelectOut_doorMapper extends BaseMapper<Out_door> {

    @Select("select temp from out_door")
    List<Out_door> selectOut_door();
}

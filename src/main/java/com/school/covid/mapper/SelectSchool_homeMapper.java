package com.school.covid.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.school.covid.entity.select.School_home;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SelectSchool_homeMapper extends BaseMapper<School_home> {

        //查询学生家庭所在地
        @Select("SELECT home FROM school")
        List<School_home> queryAll();
}

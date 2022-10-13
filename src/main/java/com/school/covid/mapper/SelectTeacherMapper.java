package com.school.covid.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.school.covid.entity.select.Teacher;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SelectTeacherMapper extends BaseMapper<Teacher> {
    @Select("select risk from teacher")
    List<Teacher> selectTeacher_risk();
    @Select("select temp from teacher")
    List<Teacher> selectTeacher_temp();
}

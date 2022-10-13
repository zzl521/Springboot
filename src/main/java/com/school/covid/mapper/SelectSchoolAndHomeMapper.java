package com.school.covid.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.school.covid.entity.select.SchoolAndHome;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SelectSchoolAndHomeMapper extends BaseMapper<SchoolAndHome> {
    //查询离校返校时形成数据
    //地点查询
    @Select("SELECT Travel,place,destination FROM home UNION ALL SELECT Travel,place,destination FROM school")
    List<SchoolAndHome> queryAll();
    @Select("SELECT risk FROM home UNION ALL SELECT risk FROM school")
    List<SchoolAndHome> queryAllRisk();
    @Select("SELECT temp from home UNION ALL SELECT temp from school")
    List<Integer> queryAllTemp();
}

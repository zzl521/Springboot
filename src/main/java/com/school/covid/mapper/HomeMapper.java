package com.school.covid.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.school.covid.entity.Home;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface HomeMapper extends BaseMapper<Home> {
}

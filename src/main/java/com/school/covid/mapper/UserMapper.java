package com.school.covid.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.school.covid.entity.admin.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}

package com.school.covid.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.school.covid.entity.admin.User;
import com.school.covid.mapper.UserMapper;
import com.school.covid.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Override
    public String login(User user) {
        return null;
    }

    @Override
    public String register(User user) {
        return null;
    }
}

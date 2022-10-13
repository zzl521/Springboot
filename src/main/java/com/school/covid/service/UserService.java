package com.school.covid.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.school.covid.entity.admin.User;

public interface UserService extends IService<User> {
    public String login(User user);
    public String register(User user);
}

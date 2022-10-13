package com.school.covid.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.school.covid.entity.manager.Teacher;
import com.school.covid.mapper.TeacherMapper;
import com.school.covid.service.TeacherService;
import org.springframework.stereotype.Service;


@Service
public class TeacherImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

}

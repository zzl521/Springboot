package com.school.covid.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.school.covid.entity.School;
import com.school.covid.entity.manager.Teacher;
import com.school.covid.mapper.SchoolMapper;
import com.school.covid.mapper.TeacherMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherMapper teacherMapper;


    @GetMapping("/find")
    @ResponseBody
    public List<Teacher> findall(){
        return teacherMapper.selectList(null);
    }

    @GetMapping("/findAll/{page}/{size}")
    public Page<Teacher> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        QueryWrapper<Teacher> wrapper=new QueryWrapper<>();
        wrapper.orderByDesc("writetime");
        Page<Teacher> page1= new Page<>(page,size);
        Page<Teacher> result=teacherMapper.selectPage(page1,wrapper).addOrder();
        return result;
    }


    @SneakyThrows
    @PostMapping("/save")
    public String save(@RequestBody Teacher emp){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String s=formatter.format(c.getTime());
        Date date=formatter.parse(s);
        emp.setWritetime(date);
        int result = teacherMapper.insert(emp);
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public Teacher findById(@PathVariable("id") Integer id){
        return teacherMapper.selectById(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody Teacher emp){
        int result=teacherMapper.updateById(emp);
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id")Long id){

        int result=teacherMapper.deleteById(id+"L");
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("/search/{searchkey}/{stext}")
    public List<Teacher> search(@PathVariable("searchkey")String searchkey, @PathVariable("stext")String stext){
        QueryWrapper<Teacher> userQueryWrapper = Wrappers.query();
        userQueryWrapper.like(searchkey,stext);
        return teacherMapper.selectList(userQueryWrapper);
    }
}

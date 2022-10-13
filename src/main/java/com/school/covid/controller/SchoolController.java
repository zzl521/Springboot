package com.school.covid.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.school.covid.entity.Home;
import com.school.covid.entity.School;
import com.school.covid.mapper.HomeMapper;
import com.school.covid.mapper.SchoolMapper;
import com.school.covid.service.HomeService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

//@CrossOrigin 跨域请求
@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    SchoolMapper schoolMapper;


    @GetMapping("/find")
    @ResponseBody
    public List<School> findall(){
        return schoolMapper.selectList(null);
    }

    @GetMapping("/findAll/{page}/{size}")
    public Page<School> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        QueryWrapper<School> wrapper=new QueryWrapper<>();
        wrapper.orderByDesc("writetime");
        Page<School> page1= new Page<>(page,size);
        Page<School> result=schoolMapper.selectPage(page1,wrapper).addOrder();
        return result;
    }

    @SneakyThrows
    @PostMapping("/save")
    public String save(@RequestBody School emp){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String s=formatter.format(c.getTime());
        Date date=formatter.parse(s);
        emp.setWritetime(date);
        int result = schoolMapper.insert(emp);
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public School findById(@PathVariable("id") Integer id){
        return schoolMapper.selectById(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody School emp){
        int result=schoolMapper.updateById(emp);
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id")Long id){

        int result=schoolMapper.deleteById(id+"L");
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("/search/{searchkey}/{stext}")
    public List<School> search(@PathVariable("searchkey")String searchkey, @PathVariable("stext")String stext){
        QueryWrapper<School> userQueryWrapper = Wrappers.query();
        userQueryWrapper.like(searchkey,stext);
        return schoolMapper.selectList(userQueryWrapper);
    }
}

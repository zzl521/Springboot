package com.school.covid.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.school.covid.entity.HealthClock;
import com.school.covid.mapper.HealthClockMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/playcard")
public class HealthClockController {
    @Autowired
    HealthClockMapper healthClockMapper;


    @GetMapping("/find")
    public List<HealthClock> findall(){
        return healthClockMapper.selectList(null);
    }

    @GetMapping("/findAll/{page}/{size}")
    public Page<HealthClock> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        QueryWrapper<HealthClock> wrapper=new QueryWrapper<>();
        wrapper.orderByDesc("writetime");
        Page<HealthClock> page1= new Page<>(page,size);
        Page<HealthClock> result=healthClockMapper.selectPage(page1,wrapper).addOrder();
        return result;
    }

    @SneakyThrows
    @PostMapping("/save")
    public String save(@RequestBody HealthClock emp){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String s=formatter.format(c.getTime());
        Date date=formatter.parse(s);
        emp.setWritetime(date);
        int result = healthClockMapper.insert(emp);
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public HealthClock findById(@PathVariable("id") Integer id){
        return healthClockMapper.selectById(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody HealthClock emp){
        int result=healthClockMapper.updateById(emp);
        if (result==1){

            return "success";
        }else {
            return "error";
        }

    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id")Long id){

        int result=healthClockMapper.deleteById(id+"L");
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("/search/{searchkey}/{stext}")
    public List<HealthClock> search(@PathVariable("searchkey")String searchkey, @PathVariable("stext")String stext){
        QueryWrapper<HealthClock> userQueryWrapper = Wrappers.query();
        userQueryWrapper.like(searchkey,stext);
        return healthClockMapper.selectList(userQueryWrapper);
    }

}

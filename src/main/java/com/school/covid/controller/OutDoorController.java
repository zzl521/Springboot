package com.school.covid.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.school.covid.entity.OutDoor;
import com.school.covid.entity.manager.Teacher;
import com.school.covid.mapper.OutDoorMapper;
import com.school.covid.mapper.TeacherMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/outdoor")
public class OutDoorController {
    @Autowired
    OutDoorMapper outDoorMapper;


    @GetMapping("/find")
    @ResponseBody
    public List<OutDoor> findall(){
        return outDoorMapper.selectList(null);
    }

    @GetMapping("/findAll/{page}/{size}")
    public Page<OutDoor> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        QueryWrapper<OutDoor> wrapper=new QueryWrapper<>();
        wrapper.orderByDesc("writetime");
        Page<OutDoor> page1= new Page<>(page,size);
        Page<OutDoor> result=outDoorMapper.selectPage(page1,wrapper).addOrder();
        return result;
    }

    @SneakyThrows
    @PostMapping("/save")
    public String save(@RequestBody OutDoor emp){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String s=formatter.format(c.getTime());
        Date date=formatter.parse(s);
        emp.setWritetime(date);
        int result = outDoorMapper.insert(emp);
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public OutDoor findById(@PathVariable("id") Integer id){
        return outDoorMapper.selectById(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody OutDoor emp){
        int result=outDoorMapper.updateById(emp);
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id")Long id){

        int result=outDoorMapper.deleteById(id+"L");
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("/search/{searchkey}/{stext}")
    public List<OutDoor> search(@PathVariable("searchkey")String searchkey, @PathVariable("stext")String stext){
        QueryWrapper<OutDoor> userQueryWrapper = Wrappers.query();
        userQueryWrapper.like(searchkey,stext);
        return outDoorMapper.selectList(userQueryWrapper);
    }
}

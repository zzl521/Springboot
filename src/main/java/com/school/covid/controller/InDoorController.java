package com.school.covid.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.school.covid.entity.Home;
import com.school.covid.entity.InDoor;
import com.school.covid.mapper.HomeMapper;
import com.school.covid.mapper.InDoorMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/indoor")
public class InDoorController {
    @Autowired
    InDoorMapper inDoorMapper;


    @GetMapping("/find")
    @ResponseBody
    public List<InDoor> findall(){
        return inDoorMapper.selectList(null);
    }

    @GetMapping("/findAll/{page}/{size}")
    public Page<InDoor> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        QueryWrapper<InDoor> wrapper=new QueryWrapper<>();
        wrapper.orderByDesc("writetime");
        Page<InDoor> page1= new Page<>(page,size);
        Page<InDoor> result=inDoorMapper.selectPage(page1,wrapper).addOrder();
        return result;
    }

    @SneakyThrows
    @PostMapping("/save")
    public String save(@RequestBody InDoor emp){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String s=formatter.format(c.getTime());
        Date date=formatter.parse(s);
        emp.setWritetime(date);
        int result = inDoorMapper.insert(emp);
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public InDoor findById(@PathVariable("id") Integer id){
        return inDoorMapper.selectById(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody InDoor emp){
        int result=inDoorMapper.updateById(emp);
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id")Long id){

        int result=inDoorMapper.deleteById(id+"L");
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("/search/{searchkey}/{stext}")
    public List<InDoor> search(@PathVariable("searchkey")String searchkey, @PathVariable("stext")String stext){
        QueryWrapper<InDoor> userQueryWrapper = Wrappers.query();
        userQueryWrapper.like(searchkey,stext);
        return inDoorMapper.selectList(userQueryWrapper);
    }
}

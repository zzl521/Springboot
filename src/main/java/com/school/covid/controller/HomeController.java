package com.school.covid.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.school.covid.entity.Home;
import com.school.covid.mapper.HomeMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

//@CrossOrigin
@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    HomeMapper homeMapper;


    @GetMapping("/find")
    @ResponseBody
    public List<Home> findall(){
        return homeMapper.selectList(null);
    }

    @GetMapping("/findAll/{page}/{size}")
    public Page<Home> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        QueryWrapper<Home> wrapper=new QueryWrapper<>();
        wrapper.orderByDesc("writetime");
        Page<Home> page1= new Page<>(page,size);
        Page<Home> result=homeMapper.selectPage(page1,wrapper).addOrder();
        System.out.println(result);
        return result;
    }


    @SneakyThrows
    @PostMapping("/save")
    public String save(@RequestBody Home emp)  {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String s=formatter.format(c.getTime());
        Date date=formatter.parse(s);
        emp.setWritetime(date);
        int result = homeMapper.insert(emp);
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public Home findById(@PathVariable("id") Integer id){
        return homeMapper.selectById(id);
    }

   @PutMapping("/update")
    public String update(@RequestBody Home emp){
        int result=homeMapper.updateById(emp);
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id")Long id){

        int result=homeMapper.deleteById(id+"L");
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }

    @GetMapping("/search/{searchkey}/{stext}")
    public List<Home> search(@PathVariable("searchkey")String searchkey, @PathVariable("stext")String stext){
        QueryWrapper<Home> userQueryWrapper = Wrappers.query();
        userQueryWrapper.like(searchkey,stext);
        return homeMapper.selectList(userQueryWrapper);
    }
}

package com.school.covid.controller;

import com.school.covid.entity.QrCode.ScanCode;
import com.school.covid.entity.manager.Teacher;
import com.school.covid.mapper.ScanCodeMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/scan")

public class ScanCodeManagerController {

    @Autowired
    private ScanCodeMapper scanCodeMapper;


    @GetMapping("/find")
    public List<ScanCode> findall(){
        return scanCodeMapper.selectList(null);
    }

    @SneakyThrows
    @PostMapping("/save")
    public String save(@RequestBody ScanCode emp){
//        Calendar c = Calendar.getInstance();
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        String s=formatter.format(c.getTime());
//        Date date=formatter.parse(s);
//        emp.setWritetime(date);
        int result = scanCodeMapper.insert(emp);
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }
    @GetMapping("/findById/{id}")
    public ScanCode findById(@PathVariable("id") Integer id){
        return scanCodeMapper.selectById(id);
    }

    @PutMapping("/update")
    public String update(@RequestBody ScanCode emp){
        int result=scanCodeMapper.updateById(emp);
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }


}

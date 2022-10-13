package com.school.covid.controller;

import com.school.covid.entity.QrCode.ScanCode;
import com.school.covid.entity.waring.SendConfig;
import com.school.covid.mapper.WaringConfigMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/send")
public class SendConfigController {

    @Autowired
    private WaringConfigMapper waringConfigMapper;


    @GetMapping("/find")
    public List<SendConfig> findall(){
        return waringConfigMapper.selectList(null);
    }

    @SneakyThrows
    @PostMapping("/save")
    public String save(@RequestBody SendConfig emp){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String s=formatter.format(c.getTime());
        Date date=formatter.parse(s);
        emp.setWritetime(date);
        int result = waringConfigMapper.insert(emp);
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }
    @DeleteMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id")Long id){

        int result=waringConfigMapper.deleteById(id+"L");
        if (result==1){
            return "success";
        }else {
            return "error";
        }
    }


}

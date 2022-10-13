package com.school.covid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.school.covid.mapper")
@SpringBootApplication
@EnableScheduling
@EnableCaching
public class DemoSchoolCovidApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSchoolCovidApplication.class, args);
    }
    

}

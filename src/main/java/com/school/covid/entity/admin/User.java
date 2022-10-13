package com.school.covid.entity.admin;

import lombok.Data;


@Data
public class User {
    private Long id;
    private String username;
    private Long password;
    private int code;  // 如果是1 则会得到管理员的权限

}

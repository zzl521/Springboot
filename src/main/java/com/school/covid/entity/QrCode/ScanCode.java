package com.school.covid.entity.QrCode;

import lombok.Data;

@Data
public class ScanCode {
    private Long id;
    private String localhost;  //本地地址
    private String network;  //公网地址
    private String expl;   //解释说明 URl功能
}

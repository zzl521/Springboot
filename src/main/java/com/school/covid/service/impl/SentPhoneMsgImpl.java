package com.school.covid.service.impl;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.tea.*;
import com.aliyun.dysmsapi20170525.*;
import com.aliyun.dysmsapi20170525.models.*;
import com.aliyun.teaopenapi.*;
import com.aliyun.teaopenapi.models.*;
import com.school.covid.service.SentPhoneMessageService;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public class SentPhoneMsgImpl implements SentPhoneMessageService {

//    public static com.aliyun.dysmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
//        Config config = new Config()
//                // 您的AccessKey ID
//                .setAccessKeyId(accessKeyId)
//                // 您的AccessKey Secret
//                .setAccessKeySecret(accessKeySecret);
//        // 访问的域名
//        config.endpoint = "dysmsapi.aliyuncs.com";
//        return new com.aliyun.dysmsapi20170525.Client(config);
//    }

    @SneakyThrows
    @Override
    public String SentP(String phoneNumber)  {
        Config config = new Config()
                // 您的AccessKey ID
                .setAccessKeyId("LTAI4FrJLREEC37vVYyQ7fAd")
                // 您的AccessKey Secret
                .setAccessKeySecret("PmdMq27EP8oLysB8InukIp61vgiZrv");
        // 访问的域名
        // config.endpoint = "dysmsapi.aliyuncs.com";
       Client client = new Client(config);
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setSignName("我爱你,直至生命最后结束的那一刻")
                .setTemplateCode("SMS_154950909")
                .setPhoneNumbers("16655072520")
                .setTemplateParam("{\"code\":\"1234\"}");
        // 复制代码运行请自行打印 API 的返回值

        return String.valueOf(client.sendSms(sendSmsRequest));
    }
}

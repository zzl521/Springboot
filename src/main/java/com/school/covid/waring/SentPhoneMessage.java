package com.school.covid.waring;

import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.teaopenapi.models.Config;
import org.springframework.stereotype.Component;

@Component
public class SentPhoneMessage {

    public static com.aliyun.dysmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                // 您的AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new com.aliyun.dysmsapi20170525.Client(config);
    }

    public String sentPhone() throws Exception {
//        java.util.List<String> args = java.util.Arrays.asList(args_);
        com.aliyun.dysmsapi20170525.Client client = SentPhoneMessage.createClient("LTAI4FrJLREEC37vVYyQ7fAd", "PmdMq27EP8oLysB8InukIp61vgiZrv");
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setSignName("阿里云短信测试")
                .setTemplateCode("SMS_154950909")
                .setPhoneNumbers("")
                .setTemplateParam("{\"code\":\"1234\"}");
        // 复制代码运行请自行打印 API 的返回值

        System.out.println(client.sendSms(sendSmsRequest));
        return null;
    }





}

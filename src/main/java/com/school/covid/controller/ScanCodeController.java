package com.school.covid.controller;


import com.school.covid.entity.QrCode.ScanCode;
import com.school.covid.mapper.ScanCodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;


@RestController
@RequestMapping("/resp")
public class ScanCodeController {

    @Autowired

    private RestTemplate restTemplate;
    @Autowired
    private ScanCodeMapper scanCodeMapper;
    //回调接口生成 填写凭证，
    @GetMapping("/download/{id}")
    public void download(@PathVariable("id") Integer id,HttpServletResponse response, HttpServletRequest request) {

//        RequestCallback requestCallback = request -> request.getHeaders()
//                .setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM, MediaType.ALL));

        // 将拿到的文件的网络地址和保存到数据库中的文件名，并且获取后缀，进行字符串拼接，得到一个完整的文件

        // 强转类型，获得json数组当中的某个字符串
        ScanCode list=scanCodeMapper.selectById(id);
        String QueryMsg=list.getNetwork();
        URL url;
        URLConnection conn;
        InputStream inputStream = null;
        try {
            // 这里填文件的url地址
            url = new URL("https://apis.juhe.cn/qrcode/api?key=5117ffb400126acb27d70461fdb860fc&type=2&fgcolor=5CB85C&&w=500&m=15&text="+QueryMsg);
            conn = url.openConnection();
            inputStream = conn.getInputStream();
            response.setContentType(conn.getContentType());
            // 使用URLEncoder.encode(fileName, "UTF-8")将文件名设置为UTF-8的编码格式

            byte[] buffer = new byte[1024];
            int len;
            OutputStream outputStream = response.getOutputStream();
            while ((len = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            // 如果发生异常，返回自定义的下载失败的提示信息
            e.printStackTrace();

        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}

package com.example.demo.pingshi.service.impl;

import com.example.demo.pingshi.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhangyu
 * @date 2020/3/23 21:25
 */
@Service("smsService")
@Slf4j
public class SmsServiceImpl implements SmsService {

    /*
       private String text;

     @Value("${siddhi.text}")
       public void setText(String text) {
           this.text = text;
       }

       @Value("${server.port}")
       private String port;
   */
    @Override
    public void sendSms(String mobile) {
        log.info("已向{}成功发短信!", mobile);
       /* log.info("aa!",text);
        log.info("bb",port);*/

    }

}

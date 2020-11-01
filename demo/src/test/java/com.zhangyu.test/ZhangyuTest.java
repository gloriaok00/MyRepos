package com.zhangyu.test;

import com.example.demo.DemoApplication;
import com.example.demo.pingshi.service.SmsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
public class ZhangyuTest {

    @Autowired
    private SmsService smsService;

    @Test
    public void testSms(){
        smsService.sendSms("13478996204");
    }
 
}
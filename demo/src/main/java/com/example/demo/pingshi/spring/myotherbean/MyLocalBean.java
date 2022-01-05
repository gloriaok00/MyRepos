package com.example.demo.pingshi.spring.myotherbean;

import org.example.config.OtherJarBean;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description
 * @date 2021-11-30 17:01
 */

@SpringBootTest
public class MyLocalBean {

    @Autowired
    private OtherJarBean aaa;

    @Test
    public void show() {
        System.out.println(aaa.a);
    }

}

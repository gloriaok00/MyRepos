package com.example.demo;

import com.example.demo.pingshi.spring.mybean.myauto.threelearn.All;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @description
 * @date 2021-11-26 13:24
 */

@SpringBootTest
public class CCC {

    @Autowired
    @Qualifier("aaa")
    private All mm;

    @Test
    public void xxx(){
       mm.show();
    }
}

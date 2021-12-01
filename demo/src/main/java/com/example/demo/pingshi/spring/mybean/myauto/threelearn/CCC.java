package com.example.demo.pingshi.spring.mybean.myauto.threelearn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description
 * @date 2021-11-26 13:24
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class CCC {

    @Autowired
    @Qualifier("aaa")
    private All mm;

    @Test
    public void xxx(){
       mm.show();
    }
}

package com.example.demo.pingshi.rest;

import com.example.demo.pingshi.spring.mybean.myauto.Human;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @description
 * @date 2022-01-23 23:43
 */

//@SpringBootTest
//@RunWith(SpringRunner.class)
public class BBB {

    @Autowired
    @Qualifier(value = "man")
    private Human h;

    //@Test
    //@GetMapping(value = "/nnn")
    public void show(){
        System.out.println(h.runMarathon());
    };
}

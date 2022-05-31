package com.example.demo.pingshi.bean;

import com.example.demo.pingshi.spring.mybean.myauto.Human;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @description
 * @date 2022-01-23 23:43
 * @date 2022-05-31 15:01
 */

public class BBean {

    @Autowired
    @Qualifier(value = "man")
    private Human h;

    public void show(){
        System.out.println(h.runMarathon());
    };

}

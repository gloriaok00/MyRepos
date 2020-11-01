package com.example.demo.pingshi.rest;

import com.example.demo.pingshi.servlet.BeanService;
import com.example.demo.pingshi.servlet.BeanService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangyu
 * @description @
 * @date 2020-09-19 12:23
 */

@RestController
public class BeanDemo {

    @Autowired
    private BeanService b1;

    @Autowired
    private BeanService1 b2;

    @GetMapping(value = "/bean/demo")
    public void show(){
        System.out.println(b1.getUser());
        System.out.println(b2.getUser());
    }
}

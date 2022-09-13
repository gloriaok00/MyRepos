package com.example.demo.mianshi.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description req不同传值学习
 * @date 2022/9/13 08:42
 */

@RequestMapping("/req")
@RestController
public class RequestRest {

    @GetMapping("/param")
    public void show1(String value) {
        System.out.println("接收到param:" + value);
    }

    @GetMapping("/form")
    public void show2(String test, String key) {
        System.out.println("接收到form-data:" + test);
        System.out.println("接收到form-data:" + key);
    }

    @GetMapping("/raw")
    public void show3(@RequestBody String test) {
        System.out.println("接收到raw:" + test);
    }

}

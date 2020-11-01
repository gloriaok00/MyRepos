package com.example.demo.pingshi.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangyu
 * @description
 * @date 2020-06-13 17:21
 */

@RestController
@ResponseBody
public class restcontroller {

    @GetMapping("/getPerson")
    public Person getPerson(){
        Person p=new Person("zy","23");
        return p;
    }

    @GetMapping("/getPerson11")
    public String getPerson11(){
        Person p=new Person("zy","23");
        return p.toString();
    }
}

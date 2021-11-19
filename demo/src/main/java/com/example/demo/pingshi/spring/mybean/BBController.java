package com.example.demo.pingshi.spring.mybean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description
 * @date 2021-11-18 22:14
 */

@RestController
public class BBController {

    @Autowired
    private BB bb;

    @Autowired
    private B1 b1;

    @GetMapping("/springbean")
    public void nnn(){
        System.out.println("查看bb对象是否拿到了:");
        bb.show();
        b1.show();
    }
}


@Configuration
class BB{

    public void show(){
        System.out.println("我是BB的show方法");
    }

    @Bean
    public B1 registB1(){
        return new B1();
    }

}

class B1{
    public B1(){
        System.out.println("我是B1的默认构造器");
    }

    public void show(){
        System.out.println("我是B1对象的show方法");
    }
}

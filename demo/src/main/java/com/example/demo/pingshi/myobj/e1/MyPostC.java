package com.example.demo.pingshi.myobj.e1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * @description
 * @date 2022/11/28 02:22
 */

@RestController
public class MyPostC {

    @PostConstruct
    public void xx(){
        System.out.println("2.我是PostConstruct");
    }

    static {
        System.out.println("1.我是static啊啊啊 查看加载顺序");
    }

    @GetMapping("/xx1")
    public void xxx(){
        System.out.println(SE1.a+" ldndsfaf");
    }
}

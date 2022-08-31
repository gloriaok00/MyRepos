package com.example.demo.pingshi.myfinal.init;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.HashMap;

/**
 * @description final全局变量随机练习
 * @date 2022/8/31 11:36
 */

@RestController
@RequestMapping("/final")
public class FinalFiled {

    //map本身是复合类型 所以他地址不变 final这里编译就是可以通过的
    private final HashMap<String,String> map=new HashMap();

    @PostConstruct
    public void init(){
        System.out.println("sdsaddsf");
        map.put("k1","v1");
        //不让更改地址
        //map=new HashMap<>();
    }

    @GetMapping(value = "/x1")
    public void xx(){
        map.put("k2","v2");
        map.keySet().forEach(System.out::println);
    }

    @GetMapping(value = "/x2")
    public void xx2(){
        map.put("k3","v3");
        map.keySet().forEach(System.out::println);
    }

}

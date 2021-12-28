package com.example.demo.pingshi.java8stream.mylambda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @description
 * @date 2021-12-28 09:30
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class BirdMain {

    @Resource
    private BirdService b11;

    //No qualifying bean of type 'com.example.demo.pingshi.java8stream.mylambda.BirdService' available: expected single matching bean but found 2: b11,bird2
    //不加单独的命名时，类名的小写就是bean名了
    @Resource
    private BirdService bird2;

    @Bean
    public BirdService bird3(){
        return new Bird3();
    }

    @Bean
    public BirdService bird4(){
        //return (int a,int b) -> b/a;
        //return ( a, b) -> b/a;
        return (a,b) -> {return b/a;};
    }

    @Test
    public void usingBean(){
        System.out.println(b11.fly(10, 20));
        System.out.println(bird2.fly(10, 20));
        System.out.println(bird3().fly(10, 20));
        System.out.println(bird4().fly(10, 20));
    }
}

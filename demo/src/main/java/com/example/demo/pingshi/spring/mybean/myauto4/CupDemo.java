package com.example.demo.pingshi.spring.mybean.myauto4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @description 再学习spring 注入
 * @date 2022-01-03 15:17
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class CupDemo {

    //@Autowired
    //@Resource
    @Resource(name = "b1")
    public Cup cup;

    @Resource(name = "b22")
    public Cup cup2;

    //只有myDog这一类实现了dog，@resource按名字没匹配上就自动按类型了
    @Resource
    public Dog dog;

    @Test
    public void show() {
        System.out.println(cup.havingWater());
        System.out.println(cup2.havingWater());
        System.out.println(dog.wangwang());
    }

}

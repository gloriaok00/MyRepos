package com.example.demo.pingshi.spring.mybean.myauto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HumanRun {

    //启动时会报错，当没指定name或type时，@resource也去按type去装配了，但有两个，所以也不行了
    //@Resource()
    @Autowired
    @Qualifier("woman")//按名称匹配
    private Human human;

    @Test
    public void runMarathon() {

        System.out.println("bb:"+human.runMarathon());

    }
}

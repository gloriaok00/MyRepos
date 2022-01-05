package com.example.demo.pingshi.spring.myproperties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @description
 * @date 2021-12-08 21:46
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainRemote {

    @Autowired
    private RemoteProp remoteProp;

    @Test
    public void show() {
        System.out.println("从配置文件装配完的属性为:");
        System.out.println(remoteProp.getIp());
        System.out.println(remoteProp.getName());
        System.out.println(remoteProp.getPassword());
    }
}

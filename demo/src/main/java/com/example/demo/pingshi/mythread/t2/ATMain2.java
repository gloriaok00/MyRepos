package com.example.demo.pingshi.mythread.t2;

import com.example.demo.pingshi.spring.mybean.myauto.Human;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description
 * @date 2022-03-21 10:59
 */

@RestController
public class ATMain2 {

    @Resource(name = "man")
    private Human human;

    @GetMapping(value = "/ddd")
    public void show() {
        int a=12;
        Thread t2=new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("这是? "+a);
                System.out.println("这是?？ "+human.toString());
            }
        };
        t2.start();
        System.out.println("起始线程:"+Thread.currentThread().getName());
        System.out.println("终止线程:"+Thread.currentThread().getName());
    }
}

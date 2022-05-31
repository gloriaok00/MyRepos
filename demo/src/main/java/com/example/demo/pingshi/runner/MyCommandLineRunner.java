package com.example.demo.pingshi.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *  @description  作用就是spring启动时会执行
 *  @date  2022/5/31 17:47
 */

@Component
@Order(value = 12)
public class MyCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner接口测试");
    }
}

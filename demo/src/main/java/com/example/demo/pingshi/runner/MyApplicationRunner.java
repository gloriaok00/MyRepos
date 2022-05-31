package com.example.demo.pingshi.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @description 作用就是spring启动时会执行
 * @date 2022/5/31 17:47
 */

@Component
@Order(value = 13)
public class MyApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(args);
        System.out.println("这是ApplicationRunner测试接口");
    }
}

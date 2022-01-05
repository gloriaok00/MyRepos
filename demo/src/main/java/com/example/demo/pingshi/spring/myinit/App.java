package com.example.demo.pingshi.spring.myinit;

import com.example.demo.pingshi.spring.myinit.sub.A;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author zhangyu
 * @description
 * @date 2021-10-22 16:36
 */

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        A a = context.getBean(A.class);
        a.show();
    }
}

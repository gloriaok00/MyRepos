package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//"org.example"为mvndemo项目里的包路径，为了把里面的OtherJarBean扫进来
//"com.example.demo"为demo工程的目录
@ComponentScan({"org.example", "com.example.demo"})
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ServletComponentScan
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

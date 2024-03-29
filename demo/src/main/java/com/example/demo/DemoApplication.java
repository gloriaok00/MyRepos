package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@EnableAsync
//"org.example"为mvndemo项目里的包路径，为了把里面的OtherJarBean扫进来
//"com.example.demo"为demo工程的目录
@ComponentScan({"org.example", "com.example.demo"})
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ServletComponentScan
@ImportResource(locations={"classpath:bean.xml"})
@MapperScan(basePackages = {"com.example.demo.mbs.cus.dao","com.example.demo.pingshi.mytrans.t2.dao"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

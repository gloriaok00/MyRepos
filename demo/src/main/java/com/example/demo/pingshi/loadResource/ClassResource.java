package com.example.demo.pingshi.loadResource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @description class这种的获取起始点就是这个class所在的位置，然后当一顿向上了之后
 * 找到与配置文件同层的就行了
 * @date 2022/7/25 17:05
 */

@RequestMapping(value = "/cc")
@RestController
public class ClassResource {

    @GetMapping(value = "/vv")
    public void show() throws IOException {
        InputStream in = this.getClass().getResourceAsStream("../../../../../application.properties");
        Properties prop = new Properties();
        prop.load(in);
        System.out.println("class:"+prop.get("logging.level"));
    }

}

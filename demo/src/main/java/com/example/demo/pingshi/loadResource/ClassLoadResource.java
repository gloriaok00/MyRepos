package com.example.demo.pingshi.loadResource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *  @description classLoad默认就是在最顶层那,其实是双亲委派后Application ClassLoad去找classpath了
 *  @date  2022/7/26 15:56
 */

@RequestMapping(value = "/cc")
@RestController
public class ClassLoadResource {

    @GetMapping(value = "/nn")
    public void show() throws IOException {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("application.properties");
        Properties prop = new Properties();
        prop.load(in);
        System.out.println("classLoad:"+prop.get("logging.level"));
    }

}

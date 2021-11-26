package com.example.demo.pingshi.spring.mybean.myauto.autowiredother;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @description  bean放在其它的类里没问题，但放在本类中就报错.
 * @description  问题已找到，一开始用@springbootTest以及@test写的就是不行。
 * 改成@RestController后就可以了 2021-11-26 15:20
 * @date 2021-11-25 16:49
 */

@Configuration
@RestController
public class NeedC {

    @Bean("cc1")
    public List<String> a1(){
        return Arrays.asList("a","b");
    };

    @Bean("cc2")
    public List<String> a2(){
        return Arrays.asList("c","d");
    };

    @Resource(name="cc2")
    private List<String> bb;

    @GetMapping
    public void ss(){
        System.out.println("mm:"+bb.get(0));
    }

}

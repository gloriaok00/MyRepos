package com.example.demo.pingshi.spring.mybean.myauto.autowiredother;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @description  把可以返回List<String>类型的bean放在其它的类里没问题，但放在本类中就@autowired报错
 * @date 2021-11-25 16:49
 */

@SpringBootTest
public class NeedC {

    @Autowired
    private List<String> bb;

    @Test
    public void ss(){
        System.out.println(bb.get(0));
    }

}

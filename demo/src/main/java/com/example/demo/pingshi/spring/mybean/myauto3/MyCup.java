package com.example.demo.pingshi.spring.mybean.myauto3;

import com.example.demo.pingshi.spring.mybean.myauto4.Cup;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @description cup是一个接口，new了后直接跟接口的实现是可以的
 * @date 2022/5/31 23:02
 */

@Component
public class MyCup {

    @Bean
    public Cup cup(){
        return new Cup() {
            @Override
            public int havingWater() {
                System.out.println("150ML");
                return 150;
            }
        };
    }
}

package com.example.demo.pingshi.spring.mybean.myauto2;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description
 * @date 2022-01-02 22:44
 */

public class CatMain {

    @Test
    public void testBeanLifeCircle04() {
        //创建IOC容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CatConfig.class);
        //关闭IOC容器
        context.close();
    }

}

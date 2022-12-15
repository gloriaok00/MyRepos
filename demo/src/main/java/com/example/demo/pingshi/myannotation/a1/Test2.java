package com.example.demo.pingshi.myannotation.a1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @description 自定义注解
 * @date 2022/12/14 22:58
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface Test2 {

    String value() default "我是另一个注解";
}

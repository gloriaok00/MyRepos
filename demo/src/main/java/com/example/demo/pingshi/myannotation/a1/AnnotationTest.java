package com.example.demo.pingshi.myannotation.a1;

/**
 * @description
 * @date 2022/12/14 22:53
 */

@Test2("验证注解的本质")
public class AnnotationTest {

    public static void main(String[] args) {
        Test2 test2= AnnotationTest.class.getDeclaredAnnotation(Test2.class);
        System.out.println(test2.value());
    }
}

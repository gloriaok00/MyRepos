package com.example.demo.mianshi.proxy.p2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 *  @description 前后 包围等各种注解
 *  @date  2022/6/6 23:16
 */

@Component
@Aspect
public class AspectDemo {

    @Pointcut("execution(public * com.example.demo.mianshi.proxy.p2.AopController.*(..))")
    public void aopDemo() {

    }

    @Before(value = "aopDemo()")
    public void before() {
        System.out.println("@before");
    }

    @Around(value = "aopDemo()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("@around 1");
        pjp.proceed();
        System.out.println("@around 2");
    }

    @AfterReturning(value = "aopDemo()")
    public void afterReturning() {
        System.out.println("@AfterReturning");
    }

    @AfterThrowing(value = "aopDemo()")
    public void afterThrowing() {
        System.out.println("@AfterThrowing");
    }

    @After(value = "aopDemo()")
    public void after(JoinPoint joinPoint) {
        System.out.println("@After");
    }

}

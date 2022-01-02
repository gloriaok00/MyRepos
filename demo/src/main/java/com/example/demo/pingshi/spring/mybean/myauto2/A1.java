package com.example.demo.pingshi.spring.mybean.myauto2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @description  @Autowired里的和@Component本身的到底哪个先实例化
 * @date 2022-01-02 22:03
 */

@Component
public class A1 {

    @Autowired
    private A2 b;

    public A1() {
        //System.out.println("此时b还未被注入: b = "+b.toString());
        //终于弄明白了，如果是空的构造器时，会先是构造器，然后是autowired一些变量，然后是@PostConstruct
        //所以上面的语句会出错。因为B还有没有呢
        //这个与java的道理是一样的，纯java的也试过了
        System.out.println("此时b还未被注入: b = ");
    }

    public A1(A2 b) {
        this.b = b;
        //对于这种含参的构造器，就会先实例化B,就不会报错了
        System.out.println("此时b已注入: b = "+b.toString());
    }

    @PostConstruct
    public void show(){
        System.out.println("@PostConstruct将在依赖注入完成后被自动调用: b = " + b);
    }
}

@Component
class A2{

    private String s="我是A2";

}

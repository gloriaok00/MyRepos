package com.example.demo.pingshi.myfinal;


/**
 *  @description 形参与实参指向同一个对象
 *  @date  2022/10/13 09:50
 */
public class MyFinal3 {
    public static void main(String[] args) {
        MyClass1 myClass = new MyClass1();
        StringBuffer buffer = new StringBuffer("hello");
        myClass.changeValue(buffer);
        System.out.println(buffer.toString());
    }
}

class MyClass1 {

    void changeValue(StringBuffer buffer) {
        buffer.append("world");
    }
}

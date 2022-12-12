package com.example.demo.pingshi.serializable.s4;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *  @description  object的就是可以直接序列化对象
 *  @date  2022/12/12 16:59
 */
public class S42 {

    @SneakyThrows
    public static void main(String[] args) {

        Person person = new Person("home", "27");

        // 将对象写入文件
        FileOutputStream os = new FileOutputStream("/Users/zhangyu/tt2.txt");
        os.write(person.toString().getBytes());
        //os.flush();
        os.close();


        // 将对象写入文件
        ObjectOutputStream os2 = new ObjectOutputStream(new FileOutputStream("/Users/zhangyu/tt3.txt"));
        //object直接把对象序列化了
        os2.writeObject(person);
        //os.flush();
        os2.close();

        // 将对象从文件中读出
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("/Users/zhangyu/tt3.txt"));
        //object又可以直接把对象反序列化了
        Person p2 = (Person) is.readObject();
        System.out.println("xx:" + p2);

    }
}

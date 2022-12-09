package com.example.demo.pingshi.serializable.s4;

import lombok.SneakyThrows;

import java.io.*;

public class S4 {

    @SneakyThrows
    public static void main(String[] args) {

        Person person = new Person("home", "27");

        // 将对象写入文件
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("tt.txt"));
        os.writeObject(person);
        os.flush();
        os.close();

        // 读取对象文件
        ObjectInputStream ins = new ObjectInputStream(new FileInputStream("tt.txt"));
        Person per = (Person) ins.readObject();
        System.out.println(per);

    }
}

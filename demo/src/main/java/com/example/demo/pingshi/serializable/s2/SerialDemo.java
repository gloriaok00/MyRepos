package com.example.demo.pingshi.serializable.s2;

import java.io.*;

/**
 * @description java对象序列化
 * @date 2022-02-28 19:42
 */
public class SerialDemo {
    public static void main(String[] args) {
        User u1 = new User(1, "kk");
        try {
            ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream("SerializableDemo"));
            outfile.writeObject(u1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SerializableDemo"));
            User u2 = (User) ois.readObject();
            System.out.println(u2.getName());
            System.out.println(u2.getId());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

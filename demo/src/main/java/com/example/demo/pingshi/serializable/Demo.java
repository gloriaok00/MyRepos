package com.example.demo.pingshi.serializable;

import java.io.*;

/**
 * @author zhangyu
 * @date 2019-10-26 14:39
 */
public class Demo {
    public static void main(String[] args) {
        User u1 = new User(1, "kui");
        //String u1="yukewei,woaini";
        //char[] u1=new char[20];
        //u1=new String("kuikuikui").toCharArray();

        try {
            ObjectOutputStream outfile = new ObjectOutputStream(new FileOutputStream("SerializableDemo"));
            outfile.writeObject(u1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            //User u2=new User();
            ObjectInputStream inoss = new ObjectInputStream(new FileInputStream("SerializableDemo"));
            User u2 = (User) inoss.readObject();
            System.out.println(u2.getName());
            System.out.println(u2.getId());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

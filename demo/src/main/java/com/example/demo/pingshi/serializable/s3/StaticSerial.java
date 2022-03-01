package com.example.demo.pingshi.serializable.s3;

import lombok.Data;

import java.io.*;

/**
 * @description 静态变量不参与序列化
 * @date 2022-02-28 22:44
 */
public class StaticSerial {

    public static void main(String[] args) {
        // 初始化
        UUser uu = new UUser();
        uu.setName("王二");
        uu.setAge(18);
        System.out.println(uu);

        // 把对象写到文件中
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("serialdemo"));) {
            oos.writeObject(uu);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 改变 static 字段的值
        UUser.staticField = "不沉默";

        // 从文件中读出对象
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serialdemo"))) {
            UUser uu1 = (UUser) ois.readObject();
            System.out.println(uu1);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

@Data
class UUser implements Serializable {
    private String name;
    private int age;

    public static String staticField = "沉默";
    transient String transientField = "王三";

}

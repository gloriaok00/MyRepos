package com.example.demo.pingshi.myreflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @description  java反射初体验
 * @date 2022-04-29 11:32
 */

public class RApple {

    private int price;

    public int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static void main(String[] args) throws Exception{
        //正射
        RApple apple = new RApple();
        apple.setPrice(5);
        System.out.println("Apple Price:" + apple.getPrice());
        //反射
        Class clz=Class.forName("com.example.demo.pingshi.myreflection.RApple");
        Method setPriceMethod=clz.getMethod("setPrice",int.class);
        Constructor<RApple> appleConstructor=clz.getConstructor();
        Object obj=appleConstructor.newInstance();
        setPriceMethod.invoke(obj,14);
        RApple rApple=(RApple)obj;
        System.out.println("反射:"+rApple.getPrice());
        //获取属性
        Field[] fields=clz.getFields();
        System.out.println("公共属性:");
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println();
        Field[] pFields=clz.getDeclaredFields();
        System.out.println("所有属性:");
        for (Field field : pFields) {
            System.out.println(field);
        }
    }
}

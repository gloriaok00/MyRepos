package com.example.demo.pingshi.initorder.c1;

/**
 *  @description 练习
 *  @date  2022/9/19 15:25
 */
public class AnimalMain {

    public static void main(String[] args) {

        System.out.println("- - - - - - - new Dog() - - - - - - -");
        Dog dog = new Dog();

        System.out.println("- - - - - - - new Dog(Integer high) - - - - - - -");
        Dog highDog = new Dog(180);

        System.out.println("- - - - - - - new Dog(String name) - - - - - - -");
        Dog nameDog = new Dog("张二狗");

        System.out.println("- - - - - - - new Dog(Integer high, String name) - - - - - - -");
        Dog highNameDog = new Dog(180, "张二狗");

    }

    static{
        System.out.println("先加载自己的静态");
    }

}

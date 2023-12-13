package com.example.demo.pingshi.duotai;
/**
 *  @description 多态的目的是为了可以动态编程
 *  @date  2023/12/13 11:09
 */
// 示例代码
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    void makeSound() {
        System.out.println("Cat meows");
    }
}

public class PolymorphismExample {
    public static void main(String[] args) {
        Animal a;

        a = new Dog();
        a.makeSound(); // 运行时调用 Dog 类的 makeSound

        a = new Cat();
        a.makeSound(); // 运行时调用 Cat 类的 makeSound
    }
}

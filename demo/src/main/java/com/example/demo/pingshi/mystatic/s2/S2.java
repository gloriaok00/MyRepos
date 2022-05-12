package com.example.demo.pingshi.mystatic.s2;

public class S2 {
    Person person = new Person("Test");
    static{
        System.out.println("test static");
    }

    public S2() {
        System.out.println("test constructor");
    }

    public static void main(String[] args) {
        new MyClass();
    }
}

class Person{
    static{
        System.out.println("person static");
    }
    public Person(String str) {
        System.out.println("person "+str);
    }
}


class MyClass extends S2 {
    static{
        System.out.println("myclass static");
    }

    public MyClass() {
        System.out.println("myclass constructor");
    }
    Person person = new Person("MyClass");

}

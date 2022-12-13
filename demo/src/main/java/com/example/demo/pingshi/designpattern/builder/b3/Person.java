package com.example.demo.pingshi.designpattern.builder.b3;

/**
 * @description
 * @date 2022/12/3 21:16
 */

public class Person {

    private int id;
    private String name;
    private int age;
    private String address;

    public static Buidler builder() {
        return new Buidler();
    }

    public Person(Buidler bb) {
        this.id = bb.id;
        this.name = bb.name;
        this.age = bb.age;
        this.address = bb.address;
    }

    @Override
    public String toString() {
        return "BBB{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    private static class Buidler {
        private int id;
        private String name;
        private int age;
        private String address;

        private Buidler id(int id) {
            this.id = id;
            return this;
        }

        private Buidler name(String name) {
            this.name = name;
            return this;
        }

        private Buidler age(int age) {
            this.age = age;
            return this;
        }

        private Buidler address(String address) {
            this.address = address;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    public static void main(String[] args) {
        Person mm = Person.builder().id(1).name("zy").age(11).address("xxx").build();
        System.out.println(mm);
    }
}

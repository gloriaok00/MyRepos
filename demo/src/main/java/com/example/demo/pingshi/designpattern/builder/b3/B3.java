package com.example.demo.pingshi.designpattern.builder.b3;

/**
 * @description
 * @date 2022/12/3 21:16
 */

public class B3 {

    private int id;
    private String name;
    private int age;
    private String address;

    private B3(Buidler buidler) {
        this.id = buidler.id;
        this.name = buidler.name;
        this.age = buidler.age;
        this.address = buidler.address;
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

        public B3 build() {
            return new B3(this);
        }
    }

    public static void main(String[] args) {
        B3 mm =  new B3.Buidler().id(1).name("zy").age(11).address("xxx").build();
        System.out.println(mm);
    }
}

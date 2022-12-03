package com.example.demo.pingshi.designpattern.builder.b2;

/**
 * @description
 * @date 2022/12/3 12:52
 */

public class B2 {

    private int id;
    private String name;
    private int age;
    private String idCard;

    public B2(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.idCard = builder.idCard;
    }

    @Override
    public String toString() {
        return "PPP{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", idCard='" + idCard + '\'' +
                '}';
    }

    private static class Builder {

        private int id;
        private String name;
        private int age;
        private String idCard;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder idCard(String idCard) {
            this.idCard = idCard;
            return this;
        }

        public B2 build() {
            return new B2(this);
        }
    }

    public static void main(String[] args) {
        B2 ppp=new B2.Builder().id(1).age(12).name("zy").idCard("220102").build();
        System.out.println(ppp);
    }
}

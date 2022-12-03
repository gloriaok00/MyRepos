package com.example.demo.pingshi.designpattern.builder.b2;

/**
 * @description
 * @date 2022/12/3 12:52
 */

public class PPP {

    private int id;
    private String name;
    private int age;
    private String idCard;

    public PPP(Builder builder) {
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

        public PPP build() {
            return new PPP(this);
        }
    }

    public static void main(String[] args) {
        PPP ppp=new PPP.Builder().id(1).age(12).name("zy").idCard("220102").build();
        System.out.println(ppp);
    }
}

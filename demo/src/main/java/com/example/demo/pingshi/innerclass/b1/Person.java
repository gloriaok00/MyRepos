package com.example.demo.pingshi.innerclass.b1;

/**
 * @description 建造者模式随机练习
 * @date 2022-05-11 10:22
 */

public class Person {

    //必选
    private int id;
    private String name;
    //可选
    private int age;
    private String address;

    private Person(Builder builder){
        this.id=builder.id;
        this.name=builder.name;
        this.age=builder.age;
        this.address=builder.address;
    };

    private static class Builder{
        private int id;
        private String name;
        private int age;
        private String address;

        public Builder(int id,String name){
            this.id=id;
            this.name=name;
        }

        public Builder setAge(int age){
            this.age=age;
            return this;
        }

        public Builder setAddress(String address){
            this.address=address;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }

    public static void main(String[] args) {
        //建造者模式练习
        Person p=new Person.Builder(1,"zy").setAge(12).build();
        System.out.println(p.id);
        System.out.println(p.name);
        System.out.println(p.age);
        System.out.println(p.address);
    }

}

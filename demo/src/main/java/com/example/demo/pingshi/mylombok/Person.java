package com.example.demo.pingshi.mylombok;

import lombok.Getter;

/**
 * @description
 * @date 2021-12-02 10:34
 */

@Getter
public class Person {

    private int id;
    private String name;
    private int age;

    private Person(Person p){
        this.id=p.id;
        this.name=p.name;
        this.age=p.age;
    }

    private Person(){};

    public static class Builder{

        private Person p1=new Person();

        public Builder(int id){
            p1.id=id;
        }

        public Builder id(int id){
            p1.id=id;
            return this;
        }

        public Builder name(String name){
            p1.name=name;
            return this;
        }

        public Builder age(int age){
            p1.age=age;
            return this;
        }

        public Person build(){
            return new Person(this.p1);
        }
    }
}

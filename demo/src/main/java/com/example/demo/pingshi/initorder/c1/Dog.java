package com.example.demo.pingshi.initorder.c1;

class Dog extends Animal {

    private String name;

    public Dog() {
        System.out.println("Dog()");
    }

    public Dog(String name) {
        this.name = name;
        System.out.println("Dog(String name)");
    }

    public Dog(Integer high) {
        super(high);
        System.out.println("Dog(Integer high)");
    }

    public Dog(Integer high, String name) {
        super(high);
        this.name = name;
        System.out.println("Dog(Integer high, String name)");
    }

    //set、get方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

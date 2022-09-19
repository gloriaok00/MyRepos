package com.example.demo.pingshi.initorder.c1;

class Animal {

    private Integer high;

    public Animal() {
        System.out.println("Animal()");
    }

    public Animal(Integer high) {
        System.out.println("Animal(Integer high)");
        this.high = high;
    }

    //set、get方法
    public Integer getHigh() {
        return high;
    }

    public void setHigh(Integer high) {
        this.high = high;
    }

}

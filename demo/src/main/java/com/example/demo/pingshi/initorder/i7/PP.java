package com.example.demo.pingshi.initorder.i7;

/**
 * @description 随机练习
 * @date 2022/9/19 13:39
 */
class PP {

    private int id;

    private String name;

    private int age;

    {
        cry();// 每个Person对象创建出来都会执行这里的代码
    }

    public PP() {

    }

    public PP(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void cry() {
        System.out.println("哇哇哇....");
    }

    public static void main(String[] args) {
        PP person = new PP();
        PP p2 = new PP(1, "aa", 1);
    }

}

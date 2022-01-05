package com.example.demo.pingshi.myexception;

public class TestCustomerException {

    public static void main(String[] args) {

        try {
            TestClass testClass = new TestClass();
            testClass.testException();
        } catch (CustomerException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
        }
    }
}

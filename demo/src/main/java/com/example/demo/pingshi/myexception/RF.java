package com.example.demo.pingshi.myexception;

/**
 * @description return and finally
 * @date 2021-12-14 20:43
 */

public class RF {

    public static void main(String[] args) {
        RF rf = new RF();
        String result = rf.show();
        System.out.println("结果:" + result);
    }

    public String show() {
        try {
            return "1";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("会不会执行呢");
        }
        return "2";
    }
}

package com.example.demo.pingshi.rest;

/**
 * @author zhangyu
 * @date 2019/12/12 23:10
 */
public class TestException {

    public static void main(String[] args) {
        try{
            throw new IllegalStateException("ddddd");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

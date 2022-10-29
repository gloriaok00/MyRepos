package com.example.demo.pingshi.myfinal.load;

/**
 * @description
 * @date 2022/10/29 12:00
 */

public class CodeAreaExecuteDemo {

    static{
        System.out.println("static code  block!");
    }

    public CodeAreaExecuteDemo(){
        System.out.println("Constructor() ");
    }
    {
        System.out.println("construct code  block!");
    }

    public static void main(String[] args) {
        new CodeAreaExecuteDemo();
    }
}

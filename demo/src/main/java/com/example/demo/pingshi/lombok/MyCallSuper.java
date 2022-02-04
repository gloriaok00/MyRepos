package com.example.demo.pingshi.lombok;

import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * @description callSuper = true时会把父类的tostring的内容也包含进来
 * @date 2022-02-04 13:22
 */

@ToString(callSuper = true)
@AllArgsConstructor
public class MyCallSuper extends BigCallSuper{
    public int b;
    public int c;

    public static void main(String[] args) {
        MyCallSuper myCallSuper=new MyCallSuper(1,2);
        System.out.println(myCallSuper);
    }

}


@ToString
class BigCallSuper{
    public int a;
}

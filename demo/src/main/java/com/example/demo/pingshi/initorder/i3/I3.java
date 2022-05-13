package com.example.demo.pingshi.initorder.i3;

/**
 *  @description 静态无法重载
 *  https://blog.csdn.net/gao_zhennan/article/details/72892946
 *  @date  2022/5/12 16:34
 */

public class I3 {
    public static void show() {
        System.out.println(" Static Method of I3");
    }

	public static void main(String[] args) {
        I3 x=new II3();
        x.show();
        I3 y=new II3();
        y.show();
        II3 z=new II3();
        z.show();
	}
}

class II3 extends I3 {
    public static void show() {
        System.out.println("Static Method of II3");
    }
}

package com.example.demo.mianshi.foreach;

/**
 * @author zhangyu
 * @date 2019-08-21 15:36
 */
public class Demo {

    private static Demo instance = null;

    private Demo() {
    }

    ;

    public static Demo getInstance() {
        if (instance == null) {
            synchronized (Demo.class) {
                if (instance == null) {
                    instance = new Demo();
                }
            }
        }

        return instance;
    }


}

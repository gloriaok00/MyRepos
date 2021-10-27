package com.example.demo.pingshi.classloader;

import groovy.sql.GroovyResultSetExtension;

/**
 * @author zhangyu
 * @description 把groovy-all-1.1-rc-1.jar也放到/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/ext/grxx
 * 里一份，类加载器就只剩ExtClassLoader了
 * @date 2021-10-23 13:37 生日快乐 宝贝
 */

public class HMain {

    public static void main(String[] args) {
       ClassLoader xx= GroovyResultSetExtension.class.getClassLoader();
       while(xx!=null){
           System.out.println(xx);
           xx=xx.getParent();
       }
    }
}

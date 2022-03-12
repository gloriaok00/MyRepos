package com.example.demo.pingshi.javamodifier;

import com.example.demo.pingshi.javamodifier.sub.MyModifier;
import org.junit.Test;

/**
 * @description https://blog.csdn.net/menglanyingfei/article/details/55210673
 * 结合这个帖子，把MyModifier从sub里拿出来到与ModifierDemo同层看看两个方法的编译效果，再拿回来也看看
 * @date 2021-12-02 14:13
 * @date 2022-03-12 13:53
 */

public class ModifierDemo extends MyModifier {

    @Test
    public void show() {
        MyModifier myModifier = new MyModifier();
       /* System.out.println(myModifier.b);
        System.out.println(myModifier.c);*/
    }

    @Test
    public void dd(){
       /* System.out.println(b);
        System.out.println(c);*/
    }
}

package com.example.demo.pingshi.initorder;

import lombok.AllArgsConstructor;

/**
 * @description
 * @date 2021-12-14 10:37
 */
//通过看编译后的源码，可以发现@AllArgsConstructor编译后的是默认调父类无参的构造器
@AllArgsConstructor
public class MySub extends MySuper {

    private int three;

   /* public MySub(int one){
        //编辑器只会默认调用父类的无参构造器，当父类没有无参构造器，而子类又没显式调用别的构造器时就报错了
        //另外，子类的构造器必须调用父类构造器。如果你看见子类也没调用父类的构造器，那是没显式调用，编译器会默认调无参构造器
        //这里显式调下父类含参的，这样能编译过去
        super(one);
    }*/

   public MySub(){
       //编辑器只会默认调用父类的无参构造器，当父类没有无参构造器，而子类又没显式调用别的构造器时就报错了
       //另外，子类的构造器必须调用父类构造器。如果你看见子类也没调用父类的构造器，那是没显式调用，编译器会默认调无参构造器
       //这里显式调下父类含参的，这样能编译过去
       super(11);
   }

}

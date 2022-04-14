package com.example.demo.pingshi.java8stream.mylambda4;

/**
 * @author zhangyu
 * @date 2022/4/8 11:26
 */
public interface StaticInterface {
    //接口里定义静态类显示是重复的，但静态方法却不重复
   static class sdfdsf{
        public void sss(){
            System.out.println("fdsf");
        }
    }

    static void xxx(){
        /*static class sdfdsf{
            public void sss(){
                System.out.println("fdsf");
            }
        }*/
       System.out.println("dfs");
    }

}

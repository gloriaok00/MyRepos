package com.example.demo.pingshi.gc;

/**
 * @author zhangyu
 * @description finalize方法逃离GC
 * @date 2020-04-16 21:53
 */

public class FinalizeEscapeGC {
    public static FinalizeEscapeGC instance=null;
    public void isAlive(){
        System.out.println("I am still alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize方法被执行了");
        instance=this;
    }

    public static void main(String[] args) throws Throwable{
        instance=new FinalizeEscapeGC();
        //第一次试着拯救自己
        instance=null;
        System.gc();

        Thread.sleep(500);
        if(instance!=null){
            instance.isAlive();
        }else{
            System.out.println("I am dead");
        }


        //第二次再试图拯救自己
        instance=null;
        System.gc();

        Thread.sleep(500);
        if(instance!=null){
            instance.isAlive();
        }else{
            System.out.println("I am dead");
        }
    }
}

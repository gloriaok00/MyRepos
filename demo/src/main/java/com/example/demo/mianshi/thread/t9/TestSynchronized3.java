package com.example.demo.mianshi.thread.t9;

public class TestSynchronized3
{
    public synchronized void test1()
    {
              int i = 5;
              while( i-- > 0)
              {
                   System.out.println(Thread.currentThread().getName() + " : " + i);
                   try
                   {
                        Thread.sleep(500);
                   }
                   catch (InterruptedException ie)
                   {
                   }
              }
    }

    public static synchronized void test2()
    {
         int i = 5;
         while( i-- > 0)
         {
              System.out.println(Thread.currentThread().getName() + " : " + i);
              try
              {
                   Thread.sleep(500);
              }
              catch (InterruptedException ie)
              {
              }
         }
    }

    public static void main(String[] args)
    {
         final TestSynchronized3 myt2 = new TestSynchronized3();
         Thread test1 = new Thread(  new Runnable() {  public void run() {  myt2.test1();  }  }, "test1"  );
         Thread test2 = new Thread(  new Runnable() {  public void run() { TestSynchronized3.test2();   }  }, "test2"  );
         test1.start();
         test2.start();
//         TestRunnable tr=new TestRunnable();
//         Thread test3=new Thread(tr);
//         test3.start();
    }

}

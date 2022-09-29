package com.example.demo.mianshi.thread.t9;

public class TestSynchronizedStatic
{
    public void test1()
    {
         synchronized(TestSynchronizedStatic.class)
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
         final TestSynchronizedStatic myt2 = new TestSynchronizedStatic();
         Thread test1 = new Thread(  new Runnable() {  public void run() {  myt2.test1();  }  }, "test1"  );
         Thread test2 = new Thread(  new Runnable() {  public void run() { TestSynchronizedStatic.test2();   }  }, "test2"  );
         test1.start();
         test2.start();
    }

}

package com.example.demo.pingshi.designpattern.guanchazhe;

public class BinaryObserver extends Observer{

   public BinaryObserver(Subject subject){
      this.subject = subject;
      this.subject.attach(this);
   }

   @Override
   public void update() {
      System.out.println( "Binary String: "
      + Integer.toBinaryString( subject.getState() ) +" 原生:"+subject.getState());
   }
}

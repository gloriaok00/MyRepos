package com.example.demo.pingshi.myserializable.s1;

@SuppressWarnings("uncheck")
public class Employee
{
   public String name;
   public String address;
   public transient int SSN;
   public int number;
   public void mailCheck()
   {
      System.out.println("Mailing a check to " + name
                           + " " + address);
   }
}

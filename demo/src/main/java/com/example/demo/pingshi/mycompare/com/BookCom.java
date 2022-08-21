package com.example.demo.pingshi.mycompare.com;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @description
 * @date 2022/8/21 16:59
 */

public class BookCom {

    public static void main(String[] args) {
        BookBean b1=new BookBean("书1",23.1f);
        BookBean b2=new BookBean("书2",28.91f);
        System.out.println(b1.compareTo(b2));
        System.out.println("===============");

        // 1.创建一个实现 Comparator 接口的对象
        Comparator com = new Comparator() {
            @Override
            public int compare(Object obj1, Object obj2) {
                if (obj1 instanceof NewBookBean && obj2 instanceof NewBookBean){
                    NewBookBean newBookBean = (NewBookBean) obj1;
                    NewBookBean newBookBean1 = (NewBookBean) obj2;
                    //具体比较方法参照 自然排序的 compareTo 方法，这里只举个栗子
                    return (int) (newBookBean.getPrice() - newBookBean1.getPrice());
                }
                return 0;
            }
        };

        //2.将此对象作为形参传递给 TreeSet 的构造器中
        TreeSet<NewBookBean> treeSet = new TreeSet<NewBookBean>(com);

        //3.向 TreeSet 中添加 步骤 1 中 compare 方法中设计的类的对象
        treeSet.add(new NewBookBean("A",34));
        treeSet.add(new NewBookBean("S",1));
        treeSet.add( new NewBookBean("V",46));
        treeSet.add( new NewBookBean("Q",26));

        treeSet.forEach(e-> System.out.println(e.getName()+":"+e.getPrice()));

    }
}

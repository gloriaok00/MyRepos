package com.example.demo.pingshi.datatype.rm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @description 今天结合https://www.cnblogs.com/dolphin0520/p/3933551.html
 * 还是对于源码看的不是特别的明白 只能先这样了
 * https://www.cnblogs.com/softidea/p/3760213.html结合这个也是稍稍明白那么一点点
 * @date 2022-04-21 10:53
 */

public class ListRemove1 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        //这里 final int expectedModCount = modCount;把这两个值统一了
        list.removeIf(integer -> integer == 2);
    }

    @Test
    public void show(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer integer = iterator.next();
            if(integer==2)
                //出错，打开循环的时候同时又更改循环了
                //list.remove(integer);
                //用iterator的remove就好了，至少打开和移除都用同一个在控制
                iterator.remove();
        }
    }
}

package com.example.demo.pingshi.mylist;

import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @description 随机练习
 * @date 2022/11/21 21:57
 */

public class CAL {

    public static void main(String[] args) {
        TimeZone timeZone = TimeZone.getTimeZone("Asia/Shanghai");
        System.out.println(Arrays.toString(TimeZone.getAvailableIDs()));
        //使用Calendar日历类对日期进行加减
        Calendar calendar = Calendar.getInstance();
        System.out.println(TimeZone.getDefault());
        calendar.add(Calendar.HOUR, +8);
        Date startDateNew = calendar.getTime();
    }

    @Test
    public void xx(){
        int[] aa={1,3,43,2};
        System.out.println(Arrays.toString(aa));
    }
}

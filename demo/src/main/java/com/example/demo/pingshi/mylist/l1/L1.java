package com.example.demo.pingshi.mylist.l1;

import java.util.Arrays;
import java.util.List;

/**
 * @description 模拟问题
 * @date 2022/12/8 17:27
 */

public class L1 {

    public static void main(String[] args) {
        int[] xx = {1, 2, 3, 45, 67};
        //asList的参数类型为泛型 所以直接被当成了Object
        List mm= Arrays.asList(xx);
        System.out.println(mm.size());
    }
}

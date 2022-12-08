package com.example.demo.pingshi.java8stream.s5;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description
 * @date 2022/12/8 16:51
 */

public class S55 {

    @Test
    public void ii() {
        //注意两处写法的区别，这种的就不受内部静态类的限制了
        List<Integer> o1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        o1.add(1);

        List<Integer> o11 = Arrays.asList(1, 2, 3);
        //o11.add(1);
        //o11.add(2);
    }

}

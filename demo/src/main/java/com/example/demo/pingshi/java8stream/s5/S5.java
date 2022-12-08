package com.example.demo.pingshi.java8stream.s5;

import lombok.Builder;
import lombok.Data;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description
 * @date 2022/12/8 14:40
 */

@Data
@Builder
public class S5 {

    private int id;
    private String name;
    private int a1;

    @Test
    public void mm() {
        S5 m1 = S5.builder().id(1).name("xxx").build();
        System.out.println(m1.toString());
    }


    public static void main(String[] args) {
        S5 m1 = S5.builder().name("1号").a1(1).build();
        S5 m2 = S5.builder().name("1号").a1(2).build();
        S5 m3 = S5.builder().name("2号").a1(3).build();
        S5 m4 = S5.builder().name("2号").a1(4).build();
        List<S5> list = Arrays.asList(m1, m2, m3, m4);
        Map<String, List<S5>> pp = list.stream().collect(Collectors.groupingBy(S5::getName));
        pp.forEach((k, v) -> {
            CCom cc = new CCom();
            cc.setName(k);
            cc.setSum(v.stream().mapToInt(S5::getA1).sum());
            System.out.println(cc);
        });

        Map<String, Integer> ll = list.stream().collect(
                Collectors.groupingBy(S5::getName, Collectors.summingInt(S5::getA1)));

    }

}

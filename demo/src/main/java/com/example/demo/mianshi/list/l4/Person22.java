package com.example.demo.mianshi.list.l4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangyu
 * @date 2019/12/11 09:43
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person22 implements Comparable<Person22> {

    private String name;
    private int age;

    @Override
    public int compareTo(Person22 o) {
        if (this.age > o.age) {
            return 1;
        } else if (this.age < o.age) {
            return -1;
        } else {
            return 0;
        }
    }
}

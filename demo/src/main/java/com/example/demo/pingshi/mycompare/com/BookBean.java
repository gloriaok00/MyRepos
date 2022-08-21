package com.example.demo.pingshi.mycompare.com;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @description
 * @date 2022/8/21 16:51
 */

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class BookBean implements Comparable<BookBean> {

    private String name;
    private float price;

    @Override
    public int compareTo(BookBean o) {
        if (this.getPrice() > o.getPrice()) {
            return 1;
        } else if (this.getPrice() == o.getPrice()) {
            //再比较name
            return this.getName().compareTo(o.getName());
        } else {
            return -1;
        }
    }
}

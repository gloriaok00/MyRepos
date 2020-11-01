package com.example.demo.pingshi.session;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 书
 * @author zhangyu
 * @date 2020/3/29 10:09
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Comparable{

    private Integer id;
    private String name;

    @Override
    public int compareTo(Object o) {

        Book b = (Book)(o);
        return this.id - b.id;

    }
}

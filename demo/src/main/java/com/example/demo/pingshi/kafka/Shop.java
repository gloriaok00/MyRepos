package com.example.demo.pingshi.kafka;

import com.example.demo.pingshi.session.Book;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

/**
 * @author zhangyu
 * @description
 * @date 2020-07-10 15:19
 */

@Data
@AllArgsConstructor
public class Shop {

    private int shopid;
    private String user;
    private Book book;
    private Map<String,String> googleMap;

}

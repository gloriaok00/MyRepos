package com.example.demo.pingshi.session;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * 书操作
 * 主要为了学习session对象
 *
 * @author zhangyu
 * @date 2020/3/29 10:10
 */

@Slf4j
@RestController
public class BookRest {

    public static HashMap<String, Book> books = new HashMap();

    /*
     * 初始化书籍
     */
    static {
        books.put("1", new Book(1, "小狗钱钱"));
        books.put("2", new Book(2, "宏观经济学"));
        books.put("3", new Book(3, "我的前半生"));
    }

    /**
     * 根据ID查找书籍
     */
    public static Book getBookById(String id) {
        log.info("enter getBookById");
        return books.get(id);
    }

    /**
     * 放入某本书籍
     */
    @GetMapping(value = "/book/save/shoppingcar")
    public String saveShoppingCarById(HttpServletRequest request, @RequestParam String id) {
        log.info("enter saveShoppingCarById id={}", id);
        HttpSession session = request.getSession();
        log.info("sessionId={}", session.getId());
        session.setAttribute("books", id);
        return "放入编号为" + id + "的书到购物车成功";
    }

    /**
     * 显示所有购物车书籍
     */
    @GetMapping(value = "/book/show/shoppingcar")
    public String showShoppingCarBooks(HttpServletRequest request) {
        log.info("enter showShoppingCarBooks");
        HttpSession session = request.getSession();
        String saveBook = (String) session.getAttribute("books");
        if (StringUtils.isEmpty(saveBook)) {
            return "购物车空空如也";
        } else {
            JSONObject jsonData = new JSONObject();
            jsonData.put("book", getBookById(saveBook));
            return jsonData.toJSONString();
        }
    }

}

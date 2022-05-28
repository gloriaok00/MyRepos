package com.example.demo.mbs.lianxi.mb3;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @description
 * @date 2022/5/28 18:59
 */

public class MB3 {
    //测试搜索指定id的用户
    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);

        List<User> user = mapper.getUserList();

        System.out.println(user.toString());

        System.out.println("测试这里");
        sqlSession.close();
    }

}

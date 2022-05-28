package com.example.demo.mbs.lianxi.mb3;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

//sqlSessionFactory ——> sqlSession
public class MybatisUtil {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            //使用Mybatis第一步：获取sqlSessionFactory对象
            InputStream inputStream = new FileInputStream("/Users/zhangyu/IdeaProjects/MyRepos/demo/src/main/java/com/example/demo/mbs/lianxi/mb3/Mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //既然有了SqlSessionFactory, 顾名思义，我们就可以从中获得SqlSession的实例了
    //qlSession 提供了在数据库执行 SQL 命令所需的所有方法。
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

}

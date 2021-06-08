package com.example.demo.pingshi.jdbcMysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @author zhangyu
 * @description
 * @date 2021-06-08 15:53
 */

public class OracleJDBC {

    // 定义MySQL的数据库驱动程序
    public static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
    // 定义MySQL数据库的连接地址
    public static final String DBURL = "jdbc:oracle:thin:@www.ca1078.cc:31521:ORCL";
    // MySQL数据库的连接用户名
    public static final String DBUSER = "iot";
    // MySQL数据库的连接密码
    public static final String DBPASS = "rootiot1024";


    public static void main(String[] args) throws Exception {

        Connection conn = null;        // 数据库连接
        Class.forName(DBDRIVER);    // 加载驱动程序
        conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
        PreparedStatement pstmt = null;
        for (int i = 1; i < 10; i++) {
            String sql = "INSERT INTO demo(id,name) VALUES ("+i+",'zy')";//手动设置主键的自增
            pstmt = conn.prepareStatement(sql);
            pstmt.executeUpdate();    // 执行更新操作
        }
        pstmt.close();
        conn.close();            // 数据库关闭
    }
}

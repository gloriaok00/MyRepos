package com.example.demo.pingshi.jdbcMysql;


import java.sql.*;

/**
 * @author zhangyu
 * @description jdbc再学习
 * @date 2021-06-08 11:29
 * @date 2022-05-21 18:24
 */

public class MysqlJDBC {

    // MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/employees?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";


    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "!Qazxsw2";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("准备连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            if (conn != null) {
                System.out.println("数据库已连接");
            } else {
                System.out.println("无法连接到数据库!!");
                return;
            }
            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            //创建表结构
            String dpSql = "DROP TABLE IF EXISTS `demo`;";
            String cdSql = "CREATE TABLE `demo` (`id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键ID',`name` varchar(255) NOT NULL COMMENT '用户名称',`create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间', PRIMARY KEY (`id`) USING BTREE)";
            stmt.execute(dpSql);
            stmt.execute(cdSql);
            String sql = "";
            for (int i = 1; i < 51; i++) {
                sql = "INSERT INTO demo(id,name,create_time) VALUES (" + i + ",'zy',now())";
                System.out.println("sql_insert:" + i + ":" + sql);
                stmt.executeUpdate(sql);
                if (i % 5 == 0) {
                    sql = "update demo set name='zy1' where id=" + i;
                    System.out.println("sql_update:" + i + ":" + sql);
                    stmt.executeUpdate(sql);
                }
            }
            stmt.close();
            conn.close();
        } catch (Exception se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}

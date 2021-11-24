package com.example.demo.pingshi.spring.datasource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootTest
class SpringJdbcApplicationTests {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() throws SQLException {

        System.out.println(dataSource.getClass() + "===========");
        Connection connection = dataSource.getConnection();

        ResultSet rs=connection.createStatement().executeQuery("select * from employees");
       if(rs.next()){

           System.out.println("xx:"+rs.getString("emp_no"));
       }

        System.out.println(jdbcTemplate + "==========");
    }
}


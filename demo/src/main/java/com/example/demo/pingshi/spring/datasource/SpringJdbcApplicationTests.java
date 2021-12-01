package com.example.demo.pingshi.spring.datasource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringJdbcApplicationTests {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void contextLoads() throws SQLException {

        System.out.println(dataSource.getClass() + "===========");
        Connection connection = dataSource.getConnection();

        ResultSet rs = connection.createStatement().executeQuery("select * from employees limit 10");
        while (rs.next()) {
            System.out.println("result:" + rs.getString("emp_no"));
        }
    }
}


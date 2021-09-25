package com.example.demo;

import com.example.demo.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private Person person;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    ApplicationContext ioc;
    @Autowired
    private DataSource dataSource;
    @Test
    public void hello(){
        boolean personService = ioc.containsBean("personService");
        if (personService){
            System.out.println("ico contains it");
        }else {
            System.out.println("ioc cant contains bean");
        }
    }
    @Test
    public void jdbc() throws SQLException {
        System.out.println(dataSource.getConnection());
        String sql = "select * from user";
        List<Object> query = jdbcTemplate.query(sql, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                while (resultSet.next()) {
                    System.out.println(resultSet.getString(1));
                }
                return null;
            }
        });
    }
    @Test
    void contextLoads() {
        System.out.println(person);
    }

}

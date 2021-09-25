package com.example.demo.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//@Configuration
public class MyDataSourceConfig {
//    @ConfigurationProperties(value = "spring.datasource")
//    @Bean
//    public DataSource dataSource(){
//        DruidDataSource dataSource = new DruidDataSource();
//        return dataSource;
//    }

//    @Bean
//    public ServletRegistrationBean statViewServlet() {
//        StatViewServlet statViewServlet = new StatViewServlet();
//        //向容器中注入 StatViewServlet，并将其路径映射设置为 /druid/*
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(statViewServlet, "/druid/*");
//        //配置监控页面访问的账号和密码（选配）
//        servletRegistrationBean.addInitParameter("loginUsername", "admin");
//        servletRegistrationBean.addInitParameter("loginPassword", "123456");
//        return servletRegistrationBean;
//    }
}

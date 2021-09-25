package com.example.demo.config;

import com.example.demo.service.PersonService;
import com.example.demo.service.impl.PersonServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class SpringConfig {
    @Bean(value = "personService")
    public PersonService personService(){
        System.out.println("注解注入实体类===>personServiceImpl");
        return new PersonServiceImpl();
    }
}

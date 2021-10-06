package com.example.demo.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @program: demo
 * @ClassName ShiroConfig
 * @description:
 * @author: lzy
 * @create: 2021-10-05 21:18
 * @Version 1.0
 **/
//@Configuration
public class ShiroConfig {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager){

        logger.info("启动shiroFilter--时间是：" + new Date());
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/static/*","anon");
        filterChainDefinitionMap.put("/logout","logout");
        filterChainDefinitionMap.put("/**","authc");
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }

    @Bean
    public Realm myShiroRealm() {
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        return myShiroRealm;

    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver(){
        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();
        properties.setProperty("DatabaseException","databaseError");
        properties.setProperty("UnauthorizedException","403");
        simpleMappingExceptionResolver.setExceptionMappings(properties);
        simpleMappingExceptionResolver.setDefaultErrorView("error");
        simpleMappingExceptionResolver.setExceptionAttribute("ex");
        return simpleMappingExceptionResolver;
    }
}
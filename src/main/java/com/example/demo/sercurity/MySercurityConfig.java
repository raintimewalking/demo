//package com.example.demo.sercurity;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
///**
// * @program: demo
// * @ClassName MySercurity
// * @description:
// * @author: lzy
// * @create: 2021-10-05 19:26
// * @Version 1.0
// **/
//@EnableWebSecurity
//public class MySercurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/css/**", "/index").permitAll()
//                .antMatchers("/user/**").hasRole("USER")
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .and()
//                .formLogin().loginPage("/login").failureUrl("/login_error")
//                .and()
//                .exceptionHandling().accessDeniedPage("/401");
//        http.logout().logoutSuccessUrl("/logout");
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("lzy").password(new BCryptPasswordEncoder().encode("123")).roles("USER");
//    }
//}
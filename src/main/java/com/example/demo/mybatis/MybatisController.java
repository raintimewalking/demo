package com.example.demo.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.expression.Ids;

import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MybatisController {
    @Autowired
    private MybatisService mybatisService;
    @ResponseBody
    @RequestMapping("/userList")
    public List<User> getUserList(@Nullable @RequestBody User user){
        List<User> resultList = mybatisService.queryUser();
       return resultList;
    }
    @RequestMapping("/user1")
    @ResponseBody
    public List<User> selectUserByUser(HttpServletRequest request, HttpServletResponse Response){
        HttpServletMapping httpServletMapping = request.getHttpServletMapping();
        User user = new User();
//        user.setUserName("ncb222");
        List<User> userList = mybatisService.selectUserByUser(user);
        return userList;

    }
    @RequestMapping("/user2")
    @ResponseBody
    public List<User> selectUserById(){
        List<String> strings = Arrays.asList("438", "439", "440");
        List<User> userList = mybatisService.selectUserByIds(strings);
        return userList;
    }

    @RequestMapping("/user3")
    @ResponseBody
    public List<User> selectUserByMap() {
        Map<String,String> paramterMap = new HashMap<>();
        paramterMap.put("userName","ncbrmp2");
        List<User> userList = mybatisService.selectUserByMap(paramterMap);
        return userList;
    }
    @RequestMapping("/user4")
    @ResponseBody
    public void userInsert() {
        User user = new User();
        user.setUserName("zhangsan");
        user.setRealName("wangwu");
        mybatisService.userInsert(user);
        System.out.println(user);
    }

    @ResponseBody
    @RequestMapping("/user5")
    public User updateUser(){
        User user = new User();
        user.setUserName("111");
        user.setRealName("222");
        user.setId("7");
        mybatisService.updateUser(user);
        return user;
    }

    @RequestMapping("/user6")
    @ResponseBody
    public Integer deleteUser(){
        List<String> ids = Arrays.asList("7","8");
        Integer result = mybatisService.deleteUser(ids);

        return result;
    }
    @ResponseBody
    @RequestMapping("/user7")
    public User selectOne(){
        String id = "438";
        User user = mybatisService.selectOne(id);
        System.out.println(user);
        return user;
    }
}

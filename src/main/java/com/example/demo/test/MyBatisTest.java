package com.example.demo.test;

import com.example.demo.mybatis.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: demo
 * @ClassName MyBatisTest
 * @description:
 * @author: lzy
 * @create: 2021-10-06 10:56
 * @Version 1.0
 **/
@Controller
public class MyBatisTest {

    @Resource
    private UserTestMapper batisTestMapper;

    @Resource
    private UserRoleTestMapper userRoleTestMapper;
    @ResponseBody
    @GetMapping("/u")
    public TestUser test(){
        String id = "1";
        TestUser user = new TestUser();
        user.setId(id);
        TestUser result = batisTestMapper.selectById(user);
        System.out.println(result);
        return result;
    }
//    @ResponseBody
//    @GetMapping("/ur")
//    public TestUserRole urtest(){
//        String id = "1";
//        TestUserRole result = userRoleTestMapper.selectById(id);
//        System.out.println(result);
//        return result;
//    }

}
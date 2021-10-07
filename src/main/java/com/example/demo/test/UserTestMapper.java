package com.example.demo.test;

import com.example.demo.mybatis.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: demo
 * @ClassName UserTestMapper
 * @description:
 * @author: lzy
 * @create: 2021-10-06 10:58
 * @Version 1.0
 **/
@Mapper
public interface UserTestMapper {

    TestUser selectById(TestUser user);

}
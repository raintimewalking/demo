package com.example.demo.test;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: demo
 * @ClassName UserRoleTestMapper
 * @description:
 * @author: lzy
 * @create: 2021-10-06 11:09
 * @Version 1.0
 **/
@Mapper
public interface UserRoleTestMapper {


    TestUserRole selectById(String id);
    TestUserRole selectByName(String name);
    List<TestUserRole> selectListById(String id);
}
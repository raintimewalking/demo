package com.example.demo.mybatis;

import com.example.demo.shiro.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
//    @Select("select * from user")
    List<User> queryUser();

    List<User> selectUserByUser(User user);

    List<User> selectUserByIds(List<String> ids);

    List<User> selectUserByMap(Map<String, String> paramterMap);

    void userInsert(User user);

    void updateUser(User user);

    Integer deleteUser(List<String> ids);

    User selectOne(String id);
}

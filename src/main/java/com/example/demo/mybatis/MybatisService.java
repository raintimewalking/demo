package com.example.demo.mybatis;


import java.util.List;
import java.util.Map;

public interface MybatisService {
    List<User> queryUser();

    List<User> selectUserByUser(User user);

    List<User> selectUserByIds(List<String> strings);

    List<User> selectUserByMap(Map<String, String> paramterMap);

    void userInsert(User user);

    void updateUser(User user);

    Integer deleteUser(List<String> ids);

    User selectOne(String id);
}

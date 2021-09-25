package com.example.demo.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.expression.Ids;

import java.util.List;
import java.util.Map;

@Service
public class MybatisServiceImpl implements MybatisService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;
    @Override
    public List<User> queryUser() {

        return userMapper.queryUser();
    }

    @Override
    public List<User> selectUserByUser(User user) {

        return userMapper.selectUserByUser(user);
    }

    @Override
    public List<User> selectUserByIds(List<String> ids) {
        return userMapper.selectUserByIds(ids);
    }

    @Override
    public List<User> selectUserByMap(Map<String, String> paramterMap) {
//        List<UserRole> userRoles = userRoleMapper.selectAll();
//        userRoles.forEach(userRole -> {
//            System.out.println(userRole);
//        });
        return userMapper.selectUserByMap(paramterMap);
    }

    @Override
    public void userInsert(User user) {
        userMapper.userInsert(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public Integer deleteUser(List<String> ids) {
        return userMapper.deleteUser(ids);
    }

    @Override
    public User selectOne(String id) {

        return userMapper.selectOne(id);
    }
}

package com.example.demo.mybatis;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRoleMapper {
    UserRole selectAll(String id);
}

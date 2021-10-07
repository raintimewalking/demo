package com.example.demo.test;

import com.example.demo.mybatis.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestUser {

    private String id;
    private String userName;
    private List<TestUserRole> userRole;
}

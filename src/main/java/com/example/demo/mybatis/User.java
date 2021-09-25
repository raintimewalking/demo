package com.example.demo.mybatis;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String id;
    private String userName;
    private String realName;

    private String email;
    private String sex;
    private UserRole userRole;
}

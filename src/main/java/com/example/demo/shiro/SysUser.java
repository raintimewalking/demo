package com.example.demo.shiro;

import java.util.List;

/**
 * @program: demo
 * @ClassName SysUser
 * @description:
 * @author: lzy
 * @create: 2021-10-05 20:49
 * @Version 1.0
 **/

public class SysUser {

    private Integer userId;
    private String userName;
    private String passWord;

    private List<SysRole> roleList;

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public SysUser(Integer userId, String userName, String passWord) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
    }

    public SysUser() {
    }
}

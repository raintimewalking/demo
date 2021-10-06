package com.example.demo.shiro;

import java.util.List;

/**
 * @program: demo
 * @ClassName SysRole
 * @description:
 * @author: lzy
 * @create: 2021-10-05 20:55
 * @Version 1.0
 **/

public class SysRole {
    private Integer roleId;
    private String roleName;

    //多对多关系
    private List<SysMenu> menuList;

    //多对多关系
    private List<SysUser> userList;// 一个角色对应多个用户

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<SysMenu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<SysMenu> menuList) {
        this.menuList = menuList;
    }

    public List<SysUser> getUserList() {
        return userList;
    }

    public void setUserList(List<SysUser> userList) {
        this.userList = userList;
    }

    public SysRole() {
    }
}

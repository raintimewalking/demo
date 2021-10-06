package com.example.demo.shiro;

import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * @program: demo
 * @ClassName SysMenu
 * @description:
 * @author: lzy
 * @create: 2021-10-05 20:56
 * @Version 1.0
 **/
public class SysMenu {

    private Integer menuId;
    private String menuName;

    private List<SysRole> roleList;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }

    public SysMenu() {
    }
}
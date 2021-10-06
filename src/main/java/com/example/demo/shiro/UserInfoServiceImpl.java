package com.example.demo.shiro;

import com.example.demo.mybatis.UserMapper;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo
 * @ClassName UserInfoServiceImpl
 * @description:
 * @author: lzy
 * @create: 2021-10-06 10:15
 * @Version 1.0
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

//    @Resource
//    private UserInfoMapper userMapper;
    @Override
    public SysUser queryByUsername(String userName) {
        String sql = "select user_id,pass_word,user_name from sys_user where user_name = ?";
        SysUser sysUser = jdbcTemplate.queryForObject(sql, new RowMapper<SysUser>() {
            @Override
            public SysUser mapRow(ResultSet rs, int rowNum) throws SQLException {
                SysUser sysUser1 = new SysUser();
                sysUser1.setUserId(rs.getInt("user_id"));
                sysUser1.setUserName(rs.getString("user_name"));
                sysUser1.setPassWord(rs.getString("pass_word"));
                return sysUser1;
            }
        }, userName);
        Integer userId = sysUser.getUserId();
        String sql2 = "select sr.role_id,sr.role_name from sys_role sr inner join sys_user_role sur on sr.role_id = sur.role_id " +
                "where sur.user_id = ?";
        SysRole sysRole = jdbcTemplate.queryForObject(sql2, new RowMapper<SysRole>() {
            @Override
            public SysRole mapRow(ResultSet rs, int rowNum) throws SQLException {
                SysRole sysRole1 = new SysRole();
                sysRole1.setRoleId(rs.getInt("role_id"));
                sysRole1.setRoleName(rs.getString("role_name"));
                return sysRole1;
            }
        }, userId);
        Integer roleId = sysRole.getRoleId();
        String sql3 = "select sm.menu_id,sm.menu_name from sys_menu sm inner join sys_role_menu srm on sm.menu_id = srm.role_id" +
                " where srm.role_id = ?";
//        List<SysMenu> sysMenus = jdbcTemplate.queryForList(sql3, new RowMapper<SysMenu>() {
//            @Override
//            public SysMenu mapRow(ResultSet rs, int rowNum) throws SQLException {
//                SysMenu sysMenu = new SysMenu();
//                sysMenu.setMenuId(rs.getInt("menu_id"));
//                sysMenu.setMenuName(rs.getString("menu_name"));
//                return sysMenu;
//            }
//        }, roleId);
        List<SysMenu> sysMenus = jdbcTemplate.query(sql3, new RowMapper<SysMenu>() {
            @Override
            public SysMenu mapRow(ResultSet rs, int rowNum) throws SQLException {
                SysMenu sysMenu = new SysMenu();
                sysMenu.setMenuName(rs.getString("menu_name"));
                sysMenu.setMenuId(rs.getInt("menu_id"));
                return sysMenu;
            }
        }, roleId);
        sysRole.setMenuList(sysMenus);
        List<SysRole> roleList = new ArrayList<>();
        roleList.add(sysRole);
        sysUser.setRoleList(roleList);
        return sysUser;
    }
}
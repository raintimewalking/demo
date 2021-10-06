package com.example.demo.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * @program: demo
 * @ClassName MyShiroRealm
 * @description:
 * @author: lzy
 * @create: 2021-10-05 21:29
 * @Version 1.0
 **/
public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private UserInfoService userInfoService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        SysUser primaryPrincipal = (SysUser)principalCollection.getPrimaryPrincipal();
        for (SysRole sysRole : primaryPrincipal.getRoleList()) {
            simpleAuthorizationInfo.addRole(sysRole.getRoleName());
            sysRole.getMenuList().forEach(menu->{
                simpleAuthorizationInfo.addStringPermission(menu.getMenuName());
            });
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String)authenticationToken.getPrincipal();
        System.out.println(authenticationToken.getCredentials());
        SysUser sysUser = userInfoService.queryByUsername(username);

        SimpleAuthenticationInfo simpleAuthenticationInfo =
                new SimpleAuthenticationInfo(sysUser,sysUser.getPassWord(),getName());
        return simpleAuthenticationInfo;
    }
}
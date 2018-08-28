package com.example.demo.base.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Md2Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.Map;

public class CustomRealm extends AuthorizingRealm {

    // 重写角色授权方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    // 重写角色认证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取参数主体传递过来的认证信息
        String userName = (String) authenticationToken.getPrincipal();

        // 根据用户名称，从数据库中查询出密码（这里模拟数据库返回的）
        String password = getPasswordByUserName(userName);
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userName,password,this.getName());
        // 盐值加密
        //simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(userName));
        // 返回自定义角色认证的方法，使用加密
        return simpleAuthenticationInfo;
    }

    // 模拟数据库
    private String getPasswordByUserName(String userName){
        Map<String,String> hashMap = new HashMap<>();
        hashMap.put(userName,"123456");
        return hashMap.get(userName);
    }

    public static void main(String[] args) {
        // 加盐（相当于再加密）
        Md2Hash md2Hash = new Md2Hash("123456","admin");
        System.out.println(md2Hash);
    }
}

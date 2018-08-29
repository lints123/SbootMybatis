package com.example.demo.common.util;

import com.example.demo.common.constants.ResponseCode;
import com.example.demo.common.entity.JSONResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

public class UserUtil {

    /**
     * 判断密码账号是否正确
     * @param username
     * @param password
     * @return
     */
    public static JSONResult isLogin(String username,String password){
        JSONResult jsonResult = null;
        try{
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            if(!subject.isAuthenticated()) {
                subject.login(token);
                // 返回登录成功处理
                jsonResult = new JSONResult(null,ResponseCode.CODE_SUCCESS,ResponseCode.MSG_LGOIN_SUCCESS,true);
            }else{
                // 返回登录失败处理
                jsonResult = new JSONResult(null,ResponseCode.CODE_FINAL,ResponseCode.MSG_LOGIN_FINAL,false);
            }
        }catch (IncorrectCredentialsException e){
            jsonResult = new JSONResult(null,ResponseCode.CODE_PASSWORD_ERROR,ResponseCode.MSG_PASSWORD_ERROR,false);
        }catch (UnknownAccountException e){
            jsonResult = new JSONResult(null,ResponseCode.CODE_ACCOUNT_ERROR,ResponseCode.MSG_ACCOUNT_ERROR,false);
        }catch (Exception e){
            jsonResult = new JSONResult(null,ResponseCode.CODE_FINAL,ResponseCode.MSG_LOGIN_FINAL,false);
        }
        return jsonResult;
    }

}

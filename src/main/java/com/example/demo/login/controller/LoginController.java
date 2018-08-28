package com.example.demo.login.controller;

import com.example.demo.common.BaseController;
import com.example.demo.common.entity.AjaxJSON;
import com.example.demo.common.entity.JSONResult;
import com.google.common.eventbus.SubscriberExceptionHandler;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller()
@RequestMapping("/index")
public class LoginController extends BaseController {

    @RequestMapping()
    public String loginUser(){
        return "login";
    }

    @RequestMapping("/login")
    @ResponseBody
    public AjaxJSON login(String username,String password){
        JSONResult jsonResult = new JSONResult();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try{
            if(!subject.isAuthenticated()){
                subject.login(token);
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return ajaxResult(jsonResult);
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

}

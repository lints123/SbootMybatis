package com.example.demo.login.controller;

import com.example.demo.common.BaseController;
import com.example.demo.common.constants.ResponseCode;
import com.example.demo.common.entity.AjaxJSON;
import com.example.demo.common.entity.JSONResult;
import com.example.demo.common.util.JsonUtil;
import com.example.demo.common.util.UserUtil;
import com.google.common.eventbus.SubscriberExceptionHandler;
import net.sf.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
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
    public JSONObject login(String username, String password){
        JSONResult jsonResult = UserUtil.isLogin(username,password);
        return JsonUtil.dealWithNull(ajaxResult(jsonResult));
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }

    @RequestMapping("/menu")
    public String menu(){
        return "menu";
    }
}

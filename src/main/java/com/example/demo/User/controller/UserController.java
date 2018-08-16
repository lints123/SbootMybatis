package com.example.demo.User.controller;

import com.example.demo.User.service.UserService;
import com.example.demo.User.medol.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;


@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public int addUser(User user){
        user.setUserId(UUID.randomUUID().toString().replace("-",""));
        user.setUserName("张三");
        user.setPassword("123");
        user.setPhone("1234567");
        return userService.addUser(user);
    }

}

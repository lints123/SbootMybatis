package com.example.demo.User.controller;

import com.example.demo.User.service.UserService;
import com.example.demo.User.medol.User;
import com.example.demo.base.entity.Page;
import com.example.demo.common.BaseParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/add", method=RequestMethod.GET)
    public int addUser(@ModelAttribute BaseParams baseParams){
        User user = new User();
        user.setUserId(UUID.randomUUID().toString().replace("-",""));
        user.setUserName("张三");
        user.setPassword("123");
        user.setPhone("1234567");
        Map<String,Object> map = new HashMap<>();
        Page page = new Page();
        page.setPageNum(1);
        page.setPageSize(20);
        map.put("page",page);
        List<User> list =  userService.findUser(map);
        for (User user1 : list){
            System.out.println(user1.toString()+">>>>>>>>>>>>>>");
        }
        return 1;
    }

}

package com.example.demo.User.service.impl;

import com.example.demo.User.service.UserService;
import com.example.demo.User.mapper.UserMapper;
import com.example.demo.User.medol.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public List<User> findUser(Map<String,Object> map) {
        return userMapper.findUserList(map);
    }


}

package com.example.demo.User.service;

import com.example.demo.User.medol.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    int addUser(User user);

    List<User> findUser(Map<String,Object> map);
}

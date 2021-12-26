package com.example.blog.service.impl;

import com.example.blog.dao.UserMapper;
import com.example.blog.entity.User;
import com.example.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserInfoById(int userId) { return userMapper.getUserInfoById(userId); }

    @Override
    public int updateUserInfo(User user) { return userMapper.updateUserInfo(user); }
}

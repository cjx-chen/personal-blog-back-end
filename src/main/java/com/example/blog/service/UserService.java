package com.example.blog.service;

import com.example.blog.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserService {
    User getUserInfoById(int userId);

    int updateUserInfo(User user);
}

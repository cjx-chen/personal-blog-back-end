package com.example.blog.dao;

import com.example.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    User getUserInfoById(int userId);

    int updateUserInfo(User user);
}

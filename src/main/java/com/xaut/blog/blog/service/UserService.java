package com.xaut.blog.blog.service;

import com.xaut.blog.blog.dao.UserMapper;
import com.xaut.blog.blog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User findUserById(int userId){
        return userMapper.selectById(userId);
    }

}

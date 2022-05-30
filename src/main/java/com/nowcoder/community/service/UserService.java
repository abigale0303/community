package com.nowcoder.community.service;

import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zyy
 * @create 2022-05-29 10:22
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User findUserId(int id)
    {
        return userMapper.selectById(id);
    }
}

package com.lfool.jwt.service.impl;

import com.lfool.jwt.dao.UserMapper;
import com.lfool.jwt.entity.User;
import com.lfool.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Author: LFool
 * @Date 2023/7/10 01:49
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}

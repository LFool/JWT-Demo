package com.lfool.jwt.service;

import com.lfool.jwt.entity.User;

/**
 * @Description: TODO
 * @Author: LFool
 * @Date 2023/7/10 01:49
 **/
public interface UserService {
    User findUserById(Integer id);
}

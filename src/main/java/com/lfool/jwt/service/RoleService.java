package com.lfool.jwt.service;

import com.lfool.jwt.entity.Role;

/**
 * @Description: TODO
 * @Author: LFool
 * @Date 2023/7/29 00:16
 **/
public interface RoleService {
    Role getRoleByUserId(Integer userId);
}

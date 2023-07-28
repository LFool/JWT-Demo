package com.lfool.jwt.service.impl;

import com.lfool.jwt.dao.RoleMapper;
import com.lfool.jwt.entity.Role;
import com.lfool.jwt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: TODO
 * @Author: LFool
 * @Date 2023/7/29 00:17
 **/
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role getRoleByUserId(Integer userId) {
        return roleMapper.selectByUserId(userId);
    }
}
